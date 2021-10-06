# medical-dispensary
JakartaEE on Azure cloud service

<b>Rest calls on local app server::</b>

curl --location --request POST 'http://desktop-qkciiu4:8080/medical-dispensary/rest/patient' \
           
           --header 'Content-Type: application/json' \
           --data-raw '{
                 "lastname": "Shaik",
                 "firstname": "Sameer",
                 "address": {
                 "address1": "addr1",
                 "address2": "addr2",
                 "city": "grand rapids",
                 "state": "MI",
                 "zipCode": "49548"}}'

curl --location --request GET 'http://desktop-qkciiu4:8080/medical-dispensary/rest/patient/all' <br>
curl --location --request POST 'http://desktop-qkciiu4:8080/medical-dispensary/rest/prescription/1/1/10/2' <br>
curl --location --request GET 'http://desktop-qkciiu4:8080/medical-dispensary/rest/prescription/1' <br>


<b>Rest calls after deploying to Azure cloud::</b>

curl --location --request POST 'https://medical-dispensary.azurewebsites.net/rest/patient' \

           --header 'Content-Type: application/json' \
           --data-raw '{
                 "lastname": "Shaik",
                 "firstname": "Sameer",
                 "address": {
                 "address1": "addr1",
                 "address2": "addr2",
                 "city": "grand rapids",
                 "state": "MI",
                 "zipCode": "49548"}}'

<br>curl --location --request GET 'https://medical-dispensary.azurewebsites.net/rest/patient/all'
<br>curl --location --request POST 'https://medical-dispensary.azurewebsites.net/rest/prescription/1/1/10/2'
<br>curl --location --request GET 'https://medical-dispensary.azurewebsites.net/rest/prescription/1'


