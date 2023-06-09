package Class7;
/*login
click on PIM

from the table choose any ID
and print out the row number of that id

please make sure that ur code is dynamic enough to cater if another row gets delted , it still prints the row correctly */

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task extends CommonMethods {
    public static void main(String[] args) {
        String url=" http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        String browser="chrome";
        openBrowserAndLaunchApplication(url,browser);

        WebElement userName= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement btnLogin= driver.findElement(By.xpath("//input[@id='btnLogin']"));
        btnLogin.click();
        WebElement pimBTN= driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pimBTN.click();
        List<WebElement> allIds= driver.findElements(By.xpath("//table/tbody/tr/td[2]"));//td id the column # 2
        for (int i = 0; i <allIds.size() ; i++) {
            String id=allIds.get(i).getText();
            if(id.equals("56310A")){
                System.out.println("the id row number : "+(i+1));
                WebElement row = driver.findElement(By.xpath(" //table/tbody/tr[" + (i + 1) + "]"));
                System.out.println(row.getText());
            }
        }




    }
}
