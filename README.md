# Автоматизации тестирования страницы деталей вакансии QA Automation на сайте hh.ru
## :link: <a target="_blank" href="https://hh.ru/vacancy/55354866?query=QA%20automation%20engineer&from=vacancy_search_catalog&hhtmFrom=vacancy_search_catalog">hh.ru - Вакансия QA Automation</a>

## :page_with_curl: Содержание:

- <a href="#computer-сode_stack">Технологии и инструменты</a>
- <a href="#clipboard-реализованные-проверки">Реализованные проверки</a>
- <a href="#robot-сборки-в-Jenkins">Сборки в Jenkins</a>
- <a href="#keyboard-запуск-из-терминала">Запуск из терминала</a>
- <a href="#bar_chart-allure-отчет">Allure отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="left">
<img width="6%" title="Java" src="screenshots/logo/Java.svg">
<img width="6%" title="Selenide" src="screenshots/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="screenshots/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="screenshots/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="screenshots/logo/JUnit5.svg">
<img width="6%" title="IntelliJ IDEA" src="screenshots/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenoid" src="screenshots/logo/Selenoid.svg">
<img width="6%" title="GitHub" src="screenshots/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="screenshots/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="screenshots/logo/Telegram.svg">
</p>



## :clipboard: Реализованные проверки
- Проверка наличия текста "QA" в названии вакансии :heavy_check_mark:
- Проверка соответствия вакансии на необходимый тип работы: удаленная работа :heavy_check_mark:
- Проверка соответствия вакансии на наличие необходимого опыта: Selenoid :heavy_check_mark:
- Проверка перехода на ввод кода при вводе валидного Email и отклике на вакансию :x: (тест failed для отражения статуса failed в отчетах)
- Проверка наличия ошибки при вводе неверного формата Email :heavy_minus_sign: (тест Disabled для отражения статуса skipped в отчетах)


## :robot: Сборки в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/Elena_qaguru_12_12_HW15/">Параметризированная сборка в Jenkins со всеми тестами</a>
<p align="center">
<img title="Jenkins Job Run with parameters" src="screenshots/jenkins-run.png.png">
</p>
<p align="center">
<img title="Jenkins Dashboard" src="screenshots/jenkins-dashboard-all.png">
</p>

 

## :keyboard: Запуск из терминала
Локальный запуск всех тестов:
```
gradle clean test
```

Локальный запуск только тестов по вакансии(c тегом demoqa):
```
gradle clean demoqa
```

Удаленный запуск всех тестов:
```
clean
test
 -Dbrowser=${BROWSER}
 -DbrowserVersion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -Dremote=${REMOTE}
```

Удаленный запуск только Smoke тестов (c тегом Smoke):
```
clean
demoqa
 -Dbrowser=${BROWSER}
 -DbrowserVersion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -Dremote=${REMOTE}
```

## :bar_chart: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="screenshots/allure-test-page.png">
</p>

## :robot: Отчет в Telegram
- ### Telegram notification message (all results)
<p align="center">
<img title="Telegram notification message (all results)" src="screenshots/telegram-bot.png">
</p>


## :film_projector: Видео пример прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="screenshots/test-run.gif">