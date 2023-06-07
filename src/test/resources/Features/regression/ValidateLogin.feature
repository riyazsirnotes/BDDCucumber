Feature: To validate login functionality

Scenario: To validate Login using valid credentials

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters username "reyaz0617" using xpath "//input[@name='username']"
And user enters password "reyaz123" using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates title to be "Adactin.com - Search Hotel"