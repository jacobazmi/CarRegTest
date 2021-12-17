package com.azmi.jacob.e2e.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {

    private File inputFile;
    private FileReader fr;
    private BufferedReader br;
    private String expectedFirstLine;
    private String st;
    private String fileContent = "";
    private String allRegs = "";
    private List<String> tableHeads;
    private List<String> tableDescriptions;
    private List<String> regList;
    private List<String> listItems;


    public void readFileScanner(String filePath) throws FileNotFoundException {
        inputFile = new File(filePath);
        Scanner scan = new Scanner(inputFile);
        while (scan.hasNextLine()) {
            fileContent = fileContent.concat(scan.nextLine() + "\n");
        }
        fileContent = fileContent.trim();
        fileContent = fileContent.replace("\n\n","\n");
    }


    public void extractRegList(String fileContent) {
        String ukRegPattern = "([A-Z]{2})([0-9]{2})\\s?([A-Z]{3})";
        Pattern pattern = Pattern.compile(ukRegPattern);
        Matcher matcher = pattern.matcher(fileContent);
        regList = new ArrayList<>();
        while (matcher.find()) {
            regList.add(matcher.group().replace(" ",""));
        }
    }

    public void createList(String content, int lineNumber){
        Scanner scanner = new Scanner(content);
            for (int i = 0; i < lineNumber; i++) {
                scanner.nextLine();
            }

            String extractedLine = scanner.nextLine();
            listItems = Arrays.asList(extractedLine.split("\\s*,\\s*"));
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public FileReader getFr() {
        return fr;
    }

    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public String getExpectedFirstLine() {
        return expectedFirstLine;
    }

    public void setExpectedFirstLine(String expectedFirstLine) {
        this.expectedFirstLine = expectedFirstLine;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getAllRegs() {
        return allRegs;
    }

    public void setAllRegs(String allRegs) {
        this.allRegs = allRegs;
    }

    public List<String> getTableHeads() {
        return tableHeads;
    }

    public void setTableHeads(List<String> tableHeads) {
        this.tableHeads = tableHeads;
    }

    public List<String> getTableDescriptions() {
        return tableDescriptions;
    }

    public void setTableDescriptions(List<String> tableDescriptions) {
        this.tableDescriptions = tableDescriptions;
    }

    public List<String> getRegList() {
        return regList;
    }

    public void setRegList(List<String> regList) {
        this.regList = regList;
    }

    public List<String> getListItems() {
        return listItems;
    }

    public void setListItems(List<String> listItems) {
        this.listItems = listItems;
    }
}
