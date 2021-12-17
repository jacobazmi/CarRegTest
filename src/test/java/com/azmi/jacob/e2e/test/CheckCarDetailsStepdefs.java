package com.azmi.jacob.e2e.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckCarDetailsStepdefs {

    private String fileContent;
    private String testFilePath;
    private ReadFile myFile = new ReadFile();
    private List<String> allRegs;
    private String reg;

    JavascriptExecutor js;

    private ArrayList<ArrayList<String>> webDesc = new ArrayList<ArrayList<String>>();
    private ArrayList<List<String>> fileDesc = new ArrayList<List<String>>();
    private int listSize;

    @Given("i want to search for registrations from {string}")
    public void iWantToSearchForRegistrationsFrom(String fileName) {
        testFilePath = "src/main/resources/"+fileName;
        System.out.println("Test file: " + fileName);
    }

    @And("UK vehicle registrations exist in file")
    public void ukVehicleRegistrationsExistInFile() throws FileNotFoundException {
        String ukRegPattern = "(([A-Z]{2})([0-9]{2})\\s([A-Z]{3}))|(([A-Z]{2})([0-9]{2})([A-Z]{3}))";
        myFile.readFileScanner(testFilePath);
        fileContent = myFile.getFileContent();
        Pattern pattern = Pattern.compile(ukRegPattern);
        Matcher matcher = pattern.matcher(fileContent);
        assertTrue(matcher.find());
    }

    @When("the file is read")
    public void theFileIsRead() throws FileNotFoundException {
        myFile.readFileScanner(testFilePath);
        System.out.println("File read successfully.");
    }

    @And("all empty lines are removed")
    public void allEmptyLinesAreRemoved() {
        assertFalse(fileContent.contains("\n\n"));
        System.out.println("No empty lines in text.");
    }

    @And("registrations are extracted")
    public void registrationsAreExtracted() {
        myFile.extractRegList(fileContent);
        allRegs = myFile.getRegList();
        System.out.println("Vehicle registrations found in file: " + allRegs);
        listSize = allRegs.size();
    }

    @And("searched for at {string}")
    public void searchedForAt(String url) {
        for (int i = 0; i < listSize; i++) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            js = (JavascriptExecutor) driver;
            Map<String, Object> vars = new HashMap<String, Object>();
            driver.get(url);
            driver.manage().window().setSize(new Dimension(1294, 1400));

            reg = allRegs.get(i);
            System.out.println("Searching " + reg + " at " + url);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(By.id("vrm-input")).click();
            driver.findElement(By.id("vrm-input")).sendKeys(reg);

            driver.findElement(By.cssSelector(".jsx-1164392954")).click();
            {
                WebElement element = driver.findElement(By.cssSelector(".jsx-2370501841:nth-child(3)"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }

            boolean failedSearch = false;
            try {
                WebDriverWait wait = new WebDriverWait(driver,2);
                wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"m\"]/div[2]/div[13]/div/div/dl/div/h5/span"),"Vehicle Not Found"));
            } catch (TimeoutException e) {
                failedSearch = true;
            }

            webDesc.add(new ArrayList<String>());
            if (!failedSearch){
                webDesc.get(i).add(null);
                System.out.println("Vehicle not found: " + reg);
            } else {
                WebDriverWait wait = new WebDriverWait(driver,5);
                wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl[1]/dd"),reg));
                List<WebElement> text = driver.findElement(By.xpath("//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]")).findElements(By.tagName("dt"));
                for (int j = 0; j < text.size(); j++) {
                    webDesc.get(i).add(driver.findElement(By.xpath("//*[@id=\"m\"]/div[2]/div[5]/div[1]/div/span/div[2]/dl["+(j+1)+"]/dd")).getText());
                }
                webDesc.get(i).remove(5);
                webDesc.get(i).remove(5);
                System.out.println("Webpage info: " + webDesc.get(i));
            }
            driver.quit();
        }
        System.out.println("\n");
    }

    @Then("the information is compared against the stored records in {string}")
    public void theInformationIsComparedAgainstTheStoredRecordsIn(String fileName) throws FileNotFoundException {
        ReadFile file = new ReadFile();
        file.readFileScanner("src/main/resources/" + fileName);
        Scanner sc = new Scanner(file.getFileContent());
        int count = 0;
        while (sc.hasNextLine()) {
            count++;
            sc.nextLine();
        }
        count = count-1;
        for (int i = 0; i < listSize; i++) {
            reg = allRegs.get(i);
            System.out.println("Scanning file for: " + reg);
            int lineNr = 0;
            file.createList(file.getFileContent(), lineNr);
            List<String> line = file.getListItems();
            while (!line.contains(reg) && lineNr<count) {
                lineNr++;
                file.createList(file.getFileContent(), lineNr);
                line = file.getListItems();
            }
            if (line.contains(reg)) {
                System.out.println("Info retrieved from file: " + line);
                fileDesc.add(i,line);

            } else {
                System.out.println("No info in file");
                fileDesc.add(new ArrayList<String>());
            }
        }
        System.out.println("File info: " + fileDesc);
        System.out.println("Web info: " + webDesc);

    }

    @And("the accuracy of the information is confirmed")
    public void theAccuracyOfTheInformationIsConfirmed() {
        String[][] compare = new String[listSize][2];
        String matchState;
        boolean fail = false;
        for (int i = 0; i < listSize; i++) {
            reg = allRegs.get(i);
            compare[i][0] = reg;
            boolean isMatch = fileDesc.get(i).equals(webDesc.get(i));
            if (isMatch) {
                matchState = "correct match";
            } else {
                matchState = "incorrect match";
                fail = true;
            }
            compare[i][1] = matchState;
        }
        System.out.println("Matches: " + Arrays.deepToString(compare));

        assertFalse("Some stored records do not match online records",fail);
    }
}
