Feature: To validate registration functionality

@wip2705
Scenario: To validate registration with valid input data

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks on link using xpath "//a[text()='New User Register Here']"
Then user validates title to be "Adactin.com - New User Registration"
When user enters text "riyaz2705" using xpath "//input[@name='username']"
And user enters text "riyaz123" using xpath "//input[@name='password']"
And user enters text "riyaz123" using xpath "//input[@name='re_password']"
And user enters text "riyaz s" using xpath "//input[@name='full_name']"
And user enters text "abcd@gmail.com" using xpath "//input[@name='email_add']"
And user enters text "ungive" using xpath "//input[@name='captcha']"
And user clicks checkbox using xpath "//input[@name='tnc_box']"

