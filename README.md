[![Test](https://github.com/Overcraft-Team/Core/actions/workflows/Dockerbuild.yml/badge.svg?branch=dev)](https://github.com/Overcraft-Team/Core/actions/workflows/Dockerbuild.yml)
# Yggdrasil Core
Dies ist der Kern des Servernetzwerks und dient als Gameserver. 
Die Architektur des monolithischen Servers ist auf viele parallel laufende Instanzen ausgelegt. 
Im Betrieb sollen die einzelnen instanzen automatisch ausgerollt und konfiguriert werden.

## Lokales Setup
1. Docker Desktop [herunterladen](https://www.docker.com/products/docker-desktop/) und installieren.
2. Das Repository klonen: ```https://github.com/Overcraft-Team/Core.git```
3. Das Projekt in IntelliJ öffnen.
4. Das Gradle Projekt laden lassen.
5. In der Konsole den Befehl: ```docker-compose up -d --build``` eingeben

Anschließend sollten bei Docker Desktop zwei laufende Container zu sehen sein.

## Hinweise für die Entwicklung
Um Codeänderungen testen zu können muss entweder ...
- ... das Projekt immer über ```docker-compose up -d --build``` gebaut werden.
- ... eine lokale Postgres Datenbank aufgesetzt sein.

## Contributing
Das Projekt besteht aus drei Branch-Stufen:
1. prod => dies ist der aktuelle Code auf dem Serversystem
2. test => der Code ist auf einem Testsystem zum Ausprobieren verfügbar
2. dev => dieser Branch beinhaltet die neusten Features
3. Temporäre Feature-Branches => dies sind einzelne Branches für jedes Feature

Um ein Feature zu implementieren, einfach ein Issue aus dem 
[Project](https://github.com/orgs/Overcraft-Team/projects/3/views/2) auswählten und dort auswählen, dass dafür ein Branch erstellt werden soll.
Hierbei den vorausgewählten Namen lassen. Diesen Branch dann lokal auschecken und das Feature implementieren.
Sobald dies fertig ist einen neuen Pull-Request auf den Dev-Branch erstellen.

#### Bei Fragen wendet euch an: 
![](https://dcbadge.vercel.app/api/shield/351264499124273152) 
![](https://dcbadge.vercel.app/api/shield/620685606447611914)
