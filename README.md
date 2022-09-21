# coworking_space

<b>Projektbeschreibung</b> <br>
In diesem Projekt geht es um eine Coworking Space Verwaltungs-Applikation, in der man Plätze buchen kann, um das Angebot des Coworking Spaces zu nutzen. <br>

<b>API documentation:</b> http://localhost:8080/swagger-ui/index.html <br>
<b>Github:</b> https://github.com/lukapetrovic15/m223_abschluss


<b>Wichtige Punkte!</b><br>
1. Der API Dokumentation (Swagger UI) Link funktioniert nur, wenn die Applikation gestartet wurde und diese auch läuft.

2. Im application.yml File muss die Datasource angepasst werden auf die eigenen Umstände, also speichern auf dem eigenen Gerät. <br>
URL, die angepasst werden muss:   
datasource: <br>
url: jdbc:h2:file:C:\Users\Luka Petrovic\Desktop\M223\m223_abschluss/exampledb

<b>Testdaten</b><br>
Die Testdaten für dieses Projekt werden nach dem Starten automatisch aus dem schema.sql und dem data.sql erstellt.
Die Files befinden sich im resources Ordner.

<b>Anforderungen:</b> <br>
In meiner Planung war es vorgegeben, dass sich die Member mit E-Mail und Passwort anmelden, jedoch gibt es nun ein Username. Beides, E-Mail und Username, können hier eingetragen werden.

<b>Client Requests:</b> <br>
Bevor man die Client Requests ausführen kann, braucht man ein gültiges Token, genauer gesagt zwei, einmal einen für den Admin und einmal einen für den Member.

Diese Tokens erstellt man sich ganz einfach, in dem man im client-requests.rest file ganz unten unter dem Kommentar 'Admin Token' und 'Member Token' das Ganze mit 'Run localhost:8080' ausführt

Nachdem man diese einzeln ausgeführt hat, kopiert man je einmal aus der Response den access_token (zuerst admin für den admin token, dann member für den member token) und verwendet ihn für die jeweiligen Rollen, admin und member, und gibt diese im http-client-env.json an! <br>
Das File "http-client.env.json" befindet sich im http-request Ordner im root Verzeichnis

<b>Projekt starten:</b> <br>
Um das Projekt zu starten, muss man in der RunConfiguration CoworkingSpaceApplication (befindet sich auf der gleichen Höhe wie der Start-Button links) auswählen. 
