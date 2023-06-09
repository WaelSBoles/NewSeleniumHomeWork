package Class8;
/*goto syntax hrms
login
click on recruitment
select a date on the calanader*/

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task extends CommonMethods {
    public static void main(String[] args) {
        String url = " http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement btnLogin = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        btnLogin.click();
        WebElement recruitmentBTN = driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']"));
        recruitmentBTN.click();
       WebElement stratDate=driver.findElement(By.xpath("//input[@id='candidateSearch_fromDate']"));
        stratDate.click();

        WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel=new Select(month);
        sel.selectByVisibleText("Feb");
        WebElement year=driver.findElement(By.xpath("//select[@class ='ui-datepicker-year']"));
        Select sel1=new Select(year);
       sel1.selectByVisibleText("1978");

      List<WebElement> alldates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
      for(WebElement dates:alldates){
          if(dates.getText().equals("20")){
           dates.click();
           break;
       }
      }






    }
}