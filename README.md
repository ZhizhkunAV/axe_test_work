# Training project for test automation of [aviasales](https://www.aviasales.ru/)

---

Aviasales is the largest service in Russia for searching and purchasing air tickets. 
Here you can find flights from 2000+ airlines and fly to 193 countries.

<a href="https://www.aviasales.ru/"><img src="./media/img/aviasales.webp"/></a>

---

## Content:

- <a href="#tools">Technologies</a>
- <a href="#scenarios">Test scenarios</a>
- <a href="#jenkins">CI/CD with Jenkins</a>
- <a href="#cli">Launch from the CLI</a>
- <a href="#allure">Allure reporting</a>
- <a href="#allure-testops">Integration with Allure TestOps</a>
- <a href="#jira">Integration with JIRA</a>
- <a href="#telegram">Bot notifications in Telegram</a>
- <a href="#video">Examples of test execution</a>


<a id="tools"></a>
## Tools and technologies:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="./media/img/Idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="./media/img/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="./media/img/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="./media/img/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="./media/img/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="./media/img/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="./media/img/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="./media/img/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="./media/img/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="./media/img/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="./media/img/JIRA.svg" width="50" height="50"  alt="Jira"/></a>
</p>

<a id="scenarios"></a>
## Test Scenarios
* [x] Verify main page elements
* [x] Verify official brands are shown in the main menu
* [x] Verify contact page contains actual information
* [x] Verify subscription is available 
* [x] Verify search works as expected
* [x] Verify blog page contains article about niacinamide
* [x] Verify basket is empty when no products were added 

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="./media/img/Jenkins.svg" width="25"/></a><a name="CI/CD with Jenkins"></a>CI/CD with [Jenkins](https://jenkins.autotests.cloud/job/zhizhkunav_aviasales/)</a>
<img alt="Jenkins" src="./media/reports/Jenkins.png"> 

### Jenkins parameters:

- `TASK` (all tests will be launched by `askmask_smoke_test` by default)
- `BROWSER` (browser, `chrome` by default)
- `BROWSER_VERSION` (version of browser, `120` by default)
- `BROWSER_SIZE` (browser windows size, `1920x1080` by default)
- `WD_HOST` (data of remote Selenoid server)

<a id="cli"></a>
## <img alt="cli" height="25" src="./media/img/run.png" width="25"> Launch from the CLI

**Local launch:**
```bash  
./gradlew clean demoqa_all_test
```

**Remote Jenkins launch:**
```bash  
clean ${TASK} -Dbrowser=${BROWSER} -DbrowserVersion=${BROWSER_VERSION} -DbrowserSize=${BROWSER_SIZE} -DwdHost=${WD_HOST}
```

<a id="allure"></a>
## <img alt="Allure" height="25" src="./media/img/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [reporting](https://jenkins.autotests.cloud/job/zhizhkunav_aviasales/3/allure/)</a>
<img alt="Allure" src="./media/reports/AllureReportExample.png"> 

`Allure` report includes:
- Test steps
- Screenshot of the page at the last step
- Page Source
- Browser console logs
- Video of execution for automated tests

<img alt="Allure2" src="./media/reports/AllureReportExample2.png">

<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="./media/img/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4225/dashboards">Allure TestOps</a>

All test cases and execution results are available in `Allure TestOps`. Dashboard contains test runs statistics:
<img alt="Dashboard" src="./media/reports/Dashboard.png">

Automated cases:
<img alt="Cases1" src="./media/reports/AutomatedCases.png">

Manual cases:
<img alt="Cases2" src="./media/reports/ManualCases.png">

Launches:
<img alt="Launch" src="./media/reports/Launches.png">



<a id="jira"></a>
## <img alt="Allure" height="25" src="./media/img/JIRA.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1220">Jira</a>

`Jira` task has information about all created test cases, their statuses and test launches results from `Allure TestOps`:

<img alt="JIRA" src="./media/reports/JIRA.png">

<a id="telegram"></a>
## <img alt="Allure" height="25" src="./media/img/Telegram.svg" width="25"/></a> Bot notifications in Telegram
After every build Telegram bot sends notification with `Allure` report:
<img alt="Bot" src="./media/reports/Telegram_screen.png"> 

<a id="video"></a>
## <img alt="Selenoid" height="25" src="./media/img/Selenoid.svg" width="25"/></a> Examples of test execution
<img alt="Video" src="./media/video/Subscription_video.gif"> 