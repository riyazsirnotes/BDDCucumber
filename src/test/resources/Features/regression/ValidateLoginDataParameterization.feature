Feature: To validate login functionality

@smoke @regression @wip2605
Scenario: To validate Login using valid credentials

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters username "reyaz0617" using xpath "//input[@name='username']"
And user enters password "reyaz123" using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates title to be "Adactin.com - Search Hotel"

@regression
Scenario Outline: To validate Login using Invalid credentials

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters username '<username>' using xpath "//input[@name='username']"
And user enters password '<password>' using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates title to be '<expTitle>'

Examples:
| username | password | expTitle |
| reyaz2605 | reyaz123 | Adactin.com - Hotel Reservation System |
| reyaz0617 | reyaz456 | Adactin.com - Hotel Reservation System |
| reyaz2605 | reyaz456 | Adactin.com - Hotel Reservation System |



