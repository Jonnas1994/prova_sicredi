package Util;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ReportGenerate {

    @Test
    public static void run(){
        try {

            gerarReport();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void gerarReport() throws IOException, InterruptedException {

        System.out.println("Gerando relatorio...");

        LocalDateTime then = LocalDateTime.now();
        String dirLocal = new File(".").getCanonicalPath();

        //Gera o report
        if (new File(dirLocal + "\\allure-results").exists()) {

            System.out.println("Gerando Report do Allure...");
            Runtime.getRuntime().exec("cmd.exe /K " +
                    "allure generate  "+ dirLocal +"\\allure-results --clean -o "+ dirLocal +"\\allure-report");

            then = LocalDateTime.now();
            File fileReport = new File(dirLocal + "\\allure-report");
            while(fileReport.exists() != true){
                if (ChronoUnit.SECONDS.between(then, LocalDateTime.now()) >= 15){
                    throw new FileNotFoundException("Ops! Não foi possivel gerar o Diretório [allure-report] :(");
                }
            }
            System.out.println("Report gerado com sucesso!");
            Thread.sleep(3000);

        }else{
            throw new FileNotFoundException("Ops! Diretório [allure-results] não encontrado :(");
        }
    }

}