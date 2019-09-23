#Spigot Plugins entwickeln

Testserver:
--------
Als erstes brauchst du einen Testserver. Lade dir dazu [hier](https://www.dropbox.com/s/b5chl7kv774ijfr/Testserver.zip?dl=1) die Dateien herunter. Klicke auf die start.bat. Nun erstelle sich die Ordner für Welt, Plugins und Co.
Der Server läuft auf der 1.14 unter ``localhost``. Wenn ihr auch mit einem 1.14.X Client spielen möchtet braucht ihr [ViaVersion](https://www.spigotmc.org/resources/viaversion.19254/) als Plugin.

Los gehts:
--------
Mache rechtsklick auf ```de.yourName``` und wähle Refactor->Rename aus. Gib dort deinen Namen (z.B Ingamenamen) ein.

Öffne nun ``Main.java``. Dort findest du 2 Methoden: ``onEnable()``&``onDisable()``. Diese werden jeweils bei Server Start/Stop ausgeführt. Wir kommen später darauf wieder zurück.

Nun legen wir richtig los. Zuerst benötigen wir immer einen EventHandler, danach das Event selbst: In unserem 1.Beispiel ist es das Event welches beim Betreten des Servers ausgelöst wird.

Da es mit der Zeit sehr unübersichtlich wird, wenn alle Events in einer Klasse stehen, kann man diese natürlich verteilen. 
Als erstes erstellt man eine neue Klasse und fügt ``implements Listener `` hinzu (siehe Test.java).
Bevor wir nun wieder mit EventHandlern und Co loslegen müssen wir in der ``onEnable()`` Methode folgendes ergänzen: ``getServer().getPluginManager().registerEvents(new Test(), this);`` wobei Test() immer durch den jeweilen Klassennamen ersetzt werden muss.

Plugin.yml:
--------
Ohne diese Datei funktioniert euer Plugin nicht! Darin könnt ihr den Pluginnamen, eine Beschreibung und die Pluginversion festlegen. 
Das wichtigste ist aber ``main:``, dort steht der Pfad zu der Klasse in der die onEnable Mehtode steht. Beispiel: ``main: de.yourName.Core.Main``

Quellcode ausprobieren:
--------
Wenn dies das Erste mal ist gehe bitte (im Menü oben )zuerst auf ```File```->``Build Project Structure``->``Artifacts``. Dort dann ``LearnSpigot`` auswählen und bei ``MainClass`` den Eintrag so korrigieren, dass er anstelle von ```yourName``` deinen in Schritt 1 gewählten Namen enthält.

Du geht ihr als erstes auf ```Build```->``Build Artifacts..``->``Build``. Dadurch erstellt sich im Ordner ``out/artifacts/LearnSpigot_jar/`` eure Plugin jar Datei. Diese einfach in den Plugins Ordner ziehen.
Server starten und schauen was passiert :)

Tipps und so
--------
Ich empfehle folgendes:

- Bei arbeiten mit neuen Events einfach mal event.getBlaBla eine Ausgabe packen und schauen was ausgegeben wird. Oder einfach mal irgendwelche event.setBlaBla ausprobieren und schauen inwiefern das Event beeinflusst wird
- Beim googlen am besten auf Englisch und mit Spigot als Stickwort: ``spigot teleport a Player``
- Ansonsten hab ich versucht möglichst viele (einfache) Beispiele zu verschieden Events in der Klasse Examples aufzuzählen
- Bei Fragen einfach auf Discord schreiben