# prova_sicredi_api
Prova técnica de Automação de Testes - WEB

## Como Executar?
- Instale o Framework Allure:

```
$ npm install -g allure-commandline --save-dev
```


- Execute a suite de teste de forma manual ou executando o seguitne comando:

```
$ mvn clean test -Dsurefire.suiteXmlFiles=src/test/java/Testsuites/ST_Customer.xml
```


- Após executar os testes, execute o comando abaixo para gerar o relatório no Allure

```
$ mvn -Dtest=ReportGenerate#run test
```

- Abrir o relatório Gerado

```
$ allure open
```