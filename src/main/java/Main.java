/*
Napraviti maven projekat i dodati selenium dependency.
U Mainu preko selenijuma otici na https://demoqa.com/text-box.

Zadatak je da popunite sva polja (Full Name, email, Current Address, Permanent Address) i da kliknete submit.

Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita, da nije doslo do izmene.
 Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.

 */


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Bootcamp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Isidora Zdravkovic");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("isidorazdravkovic5@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Rumenka");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Novi Sad");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");

        WebElement submitButton =driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();

        WebElement fullName1 = driver.findElement(By.id("name"));
        WebElement email1 = driver.findElement(By.id("email"));


        if (fullName1.getText().substring(5).equals(fullName.getAttribute("value"))
                && email1.getText().substring(6).equals(email.getAttribute("value"))) {
            System.out.println("Ime i mail se podudaraju ");
        } else {
            System.out.println("Ime i mail se ne podudaraju!");
        }




    }
}
