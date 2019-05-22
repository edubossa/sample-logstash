# Gateway Sample Logstash Docs

## Overview

Esse Projeto foi criado para testes de implementação com o **ELK - ElasticSearch, Logstash, Kibana**, com os pluguins e
Módulos necessários para a integração, seguimentado passo a passo.


## Step 1 - logstash-logback-encoder

Utilizamos o módulo [logstash-logback-encoder][2] o qual escreve os logs em formato JSON facilitando o envio para o ElasticSearch. 

Esse Módulo é responsavél pelo gravação assíncronas dos logs e demais configurações como por exemplo: a configuração de
campos personalizados usando o MDC.

```
<encoder class="net.logstash.logback.encoder.LogstashEncoder">
    <includeMdcKeyName>transactionId</includeMdcKeyName>
    <includeMdcKeyName>orderId</includeMdcKeyName>
</encoder>  
```

## Step 2 - Start the ELK stack using docker-compose

É necessário configurar os serviços, ElasticSearch, Logstash, Kibana, para isso usamos o [docker-elk][1]. 

```
$ docker-compose up -d
```

## Step 3 - Getting Started With Filebeat

Para submeter os arquivos para o Elastic search, utilizamos o [Filebeat][4]. [Download aqui...][3]


### Configuração Filebeat

É necessário fazer as seguintes configurações para o envio dos logs usando o Filebeat.

1. No arquivo *filebeat.yml* adicionar os caminhos referentes aos logs, é possível adicionar uma lista com vários endereços.
  
```
- input_type: log
  # Paths that should be crawled and fetched. Glob based paths.
  paths:
     - /Users/wallace/Apps/gateway/gateway-sample-logstash/log/*.log
     - /Users/wallace/Apps/gateway/gateway-web-api/log/*.log
```

2. Adicionar a seguinte configuração no arquivo *filebeat.yml* para suporte de envio dos logs no formato JSON. [structured-logging-filebeat][5]

```
### JSON configuration

# Decode JSON options. Enable this if your logs are structured in JSON.
# JSON key on which to apply the line filtering and multiline settings. This key
# must be top level and its value must be string, otherwise it is ignored. If
# no text key is defined, the line filtering and multiline features cannot be used.
json.message_key: transactionId

# By default, the decoded JSON is placed under a "json" key in the output document.
# If you enable this setting, the keys are copied top level in the output document.
json.keys_under_root: false
```

3. Inicializar o **Filebeat**

**deb:**

```
sudo /etc/init.d/filebeat start
```

**rpm:**

```
sudo /etc/init.d/filebeat start
```

**mac:**

```
sudo ./filebeat -e -c filebeat.yml -d "publish"
```

## Step 4 - jq

Caso queira visualizar os logs no formato JSON via console, utilizamos o **jq**. [Download jq][6]

```
tail -f api-payment.log | jq .
```

## Step 5 - Test
 
Após iniciar a aplicação é possível testar enviando [requisições GET ou POST][7], e acessar a [interface do Logstash][8]. 



[1]: https://github.com/deviantony/docker-elk
[2]: https://github.com/logstash/logstash-logback-encoder
[3]: https://www.elastic.co/downloads/beats/filebeat
[4]: https://www.elastic.co/guide/en/beats/filebeat/current/filebeat-getting-started.html
[5]: https://www.elastic.co/blog/structured-logging-filebeat
[6]: https://stedolan.github.io/jq/download/
[7]: http://localhost:8080/payments
[8]: http://localhost:5601/app/kibana