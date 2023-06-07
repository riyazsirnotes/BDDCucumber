Feature: To validate registration functionality

@wip2705ab
Scenario: To validate registration with valid input data

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks on link using xpath "//a[text()='New User Register Here']"
Then user validates title to be "Adactin.com - New User Registration"
When user enters details in registration form using headers
| username | password | confirm password | full name | email id | captcha |
| riyaz2705 | riyaz123 | riyaz123 | riyaz s| abcd@gmail.com | india |
And user clicks checkbox using xpath "//input[@name='tnc_box']"

