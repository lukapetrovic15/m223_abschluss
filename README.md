# coworking_space

<b>API documentation:</b> http://localhost:8080/swagger-ui/index.html <br>
<b>Github:</b> https://github.com/lukapetrovic15/m223_abschluss


<b>Wichtige Punkte!</b><br>
1. Der Swagger Link funktioniert nur, wenn die Applikation gestartet wurde und diese läuft.

2. Im application.yml File muss die Datasource angepasset werden auf die eigenen Umstände. <br>
URL, die angepasst werden muss:   
datasource: <br>
url: jdbc:h2:file:C:\Users\Luka Petrovic\Desktop\M223\m223_abschluss/exampledb

<b>Testdaten</b><br>
Die Testdaten für dieses Projekt werden nach dem Starten automatisch aus dem schema.sql und dem data.sql erstellt.
Die Files befinden sich im resources Ordner.

<b>Anforderungen:</b> <br>
In meiner Planung war es vorgegeben, dass sich die Member mit E-Mail und Passwort anmelden, jedoch gibt es nun ein Username. Beides, E-Mail und Username, können hier eingetragen werden.

<b>Client Requests:</b> <br>
Um die Client Requests ausführen zu können, braucht man ein gültiges Token, genauer gesagt zwei, einmal einen für den Admin und einmal einen für den Member.

Diese Tokens erstellt man sich über den Link der API Dokumentation unter Authorization --> /auth/token (ganz oben findet man den Link und die Anforderungen, dass es läuft).

Hier braucht man die zwei <b>Usernames</b>: admin und member <br>
Das <b>Passwort</b> ist bei beiden: password1234

Nachdem man dies ausgeführt hat, nimmt man den erstellten Tokens und verwendet ihn für die jeweiligen Rollen, admin und member, und gibt diese im http-client-env.json an!
Das File "http-client.env.json" befindet sich im http-request Ordner, ausserhalb von src

<b>Projekt starten:</b> <br>
Um das Projekt zu starten, muss man in der RunConfiguration CoworkingSpaceApplication (befindet sich auf der gleichen Höhe wie der Start-Button links) auswählen. 
