package edu.udacity.java.nano.chat;

        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.WebDriverWait;


public class WebSocketChatServerTest{


    private WebDriver webDriver;

    private String test_url = "http://localhost:8080";

    @Test
    public void loginAndJoinTest()
    {
        webDriver = new HtmlUnitDriver();
        webDriver.get(test_url);

        WebElement username = webDriver.findElement(By.name("username"));
        username.sendKeys("aaa");

        WebElement login = webDriver.findElement(By.className("submit"));
        login.click();

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                WebElement username1 = webDriver.findElement(By.name("username"));
                System.out.println("username: " + username1.getText());
                return username1.getText().equals("aaa");
            }
        });

    }

    @Test
    public void chatAndLeave()
    {
        webDriver = new HtmlUnitDriver();

        String username="aaa";
        webDriver.get(test_url+"/index?username="+username);

        WebElement sendText = webDriver.findElement(By.id("msg"));
        sendText.sendKeys("send text test");

        WebElement sendButton = webDriver.findElement(By.className("send"));
        sendButton.click();

        WebElement leaveChat = webDriver.findElement(By.className("exit"));
        leaveChat.click();

        System.out.println("GO TO MAIN PAGE: "+webDriver.getCurrentUrl());

    }

}