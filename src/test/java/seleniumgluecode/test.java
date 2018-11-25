package seleniumgluecode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class test {
    public static WebDriver driver;
    public int count = 0;

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");
    }

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]//*[@class=\"nav-action-button\"]")).click();
    }

    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
        driver.findElement(By.xpath("//*[@class=\"a-row a-spacing-base\"]//*[@id = \"ap_email\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"a-row a-spacing-base\"]//*[@id = \"ap_email\"]")).sendKeys("saisrikar.g@gmail.com");
        driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-large\"]//*[@id = 'ap_password']")).click();
        driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-large\"]//*[@id = 'ap_password']")).sendKeys("SaiSrikar@97");
        driver.findElement(By.xpath("//*[@class = \"a-section a-spacing-extra-large\"]//*[@id=\"signInSubmit\"]")).sendKeys(Keys.ENTER);
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        String exp_message = "Hello,";
        String actual = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/*[@class=\"nav-line-1\"]")).getText();
        boolean is = actual.contains(exp_message);
        if (is) {
            System.out.println("Storefront");
        }
        else
        {
            Assert.fail();
        }

    }

    @When("^user search for free ebook$")
    public void user_search_for_free_ebook() throws Throwable {
        /* clicking the kindle store from the drop down */
        driver.findElement(By.xpath("//option[@value = 'search-alias=digital-text']")).click();

        /*click on search bar and typssse free ebooks and click enter */
        driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).click();
        driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("free ebooks");
        driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys(Keys.ENTER);
    }

    @When("^user selects a free ebook$")
    public void user_selects_a_free_ebook() throws Throwable {
        /* Path to find Ebooks */

        List<WebElement> wb = driver.findElements(By.xpath("//ul[@id = 's-results-list-atf']//li"));
        for (WebElement child : wb) {
            /* Get Class name to identify Sponsored or not*/
            String class_name = child.getAttribute("class");
            System.out.println(class_name);

            /* check if the class is sponsored or not */
            if (class_name.equals("s-result-item celwidget  AdHolder")) {
                count += 1;
            } else {
                count += 1;
                driver.findElement(By.xpath("//*[@class=\"s-result-item celwidget  \"]//*[@id=\"a-autoid-2\"]/span//*[@id=\"a-autoid-2-announce\"]")).click();
                break;
            }
        }
    }

    @Then("^TYP for free ebook$")
    public void typ_for_free_ebook() throws Throwable {
        try {
            String s = driver.findElement(By.xpath("//*[@class = \"a-column a-span9 a-text-left\"]//*[@id=\"thankYouMessage\"]//h1")).getText();
            boolean isFound = s.contains("Thanks,");
            if (isFound) {
            }

        } catch (org.openqa.selenium.NoSuchElementException e) {
            String s1 = driver.findElement(By.xpath(" //*[@id=\"a-page\"]//*[@class=\"flexBoxContent\"]//h2")).getText();
            boolean isFound1 = s1.contains("Instant Order Update");
            if (isFound1) {
            }
            else {
                Assert.fail();
            }
        }
    }

    @When("^login first$")
    public void login_first() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]//*[@class=\"nav-action-button\"]")).click();
    }

    @When("^user add ebooks to new list$")
    public void user_add_ebooks_to_new_list() throws Throwable {
        /* Book 1 */
        driver.get("http://www.amazon.com/dp/B0192CTMYG");
        driver.findElement(By.xpath("//*[@id=\"wishListMainButton\"]//*[@id=\"add-to-wishlist-button-submit\"]")).click();
        WebElement r1 = driver.findElement(By.xpath("//*[@class=\"a-column a-span4 a-spacing-none\"]//*[@class=\"a-box a-spacing-base\"]//*[@class=\"a-radio a-radio-fancy a-declarative\"]"));
        r1.click();
        driver.findElement(By.xpath("//*[@class=\"a-button a-button-primary\"]//*[@class=\"a-button-input a-declarative\"]")).click();
        /* Book 2 */
        driver.get("http://www.amazon.com/dp/B0192CTMW8");
        System.out.println("Book 2");
        WebElement r2 = driver.findElement(By.xpath("//*[@id=\"wishlistButtonStack\"]//*[@class=\"a-button-inner\"]//*[@id=\"add-to-wishlist-button-submit\"]"));
        r2.click();
    }

    @Then("^Verify (\\d+) books in list$")
    public void verify_books_in_list(int arg1) throws Throwable {
        driver.findElement(By.xpath("  //*[@class=\"w-button-inner\"]")).click();
        String cn = driver.findElement(By.xpath("//*[@class=\"a-unordered-list a-nostyle a-vertical a-spacing-none g-items-section ui-sortable\"]//*[@id=\"viewItemCount\"]")).getAttribute("value");
        if(cn.equals("2"))
        {

        }
        else {
            Assert.fail();
        }
    }

    @When("^user search for ebook$")
    public void user_search_for_ebook() throws Throwable {
        /* clicking the kindle store from the drop down */
        driver.findElement(By.xpath("//option[@value = 'search-alias=digital-text']")).click();

        /*click on search bar and typssse free ebooks and click enter */
        driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).click();
        driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("paid ebooks");
        driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        List<WebElement> wb = driver.findElements(By.xpath("//ul[@id = 's-results-list-atf']//li"));
        for (WebElement child : wb) {
            /* Get Class name to identify Sponsored or not*/
            String class_name = child.getAttribute("class");
            System.out.println(class_name);

            /* check if the class is sponsored or not */
            if (class_name.equals("s-result-item celwidget  AdHolder")) {
                count += 1;
            } else {
                count += 1;
                driver.findElement(By.xpath("//*[@class=\"s-result-item celwidget  \"]//*[@class=\"a-link-normal a-text-normal\"]")).click();
                break;
            }
        }
    }

    @When("^user get sample$")
    public void user_get_sample() throws Throwable {
        //*[@id="sendSampleButton"]//*[@class="a-button-input"]
        driver.findElement(By.xpath("//*[@id=\"sendSampleButton\"]//*[@class=\"a-button-input\"]")).click();
    }

    @When("^user delete list$")
    public void user_delete_list() throws Throwable {
        driver.get("https://www.amazon.com/gp/registry/wishlist/ref=nav_youraccount_wl?ie=UTF8&requiresSignIn=1");
        WebElement el1 = driver.findElement(By.xpath("//*[@data-action=\"a-popover\"]//*[@id=\"overflow-menu-popover-trigger\"]"));
        WebElement el2 = driver.findElement(By.xpath("//*[@id=\"editYourList\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(el1).perform();
        action.moveToElement(el2).click();
        /*Click delete list */
        driver.findElement(By.xpath("//*[@class=\"a-button a-spacing-base a-button-base full-width-element\"]//*[@class=\"a-button-input\"]")).click();
        /* Click on yes*/
        driver.findElement(By.xpath("//*[@id=\"list-delete-confirm\"]//*[@class=\"a-button-input\"]")).click();
    }

    @Then("^Verify no list$")
    public void verify_no_list() throws Throwable {
       String hd= driver.findElement(By.xpath("//*[@class=\"al-intro-banner-header\"]")).getText();
       if(hd.equals("Lists"))
       {
       }
       else
       {
           Assert.fail();
       }
    }
}



