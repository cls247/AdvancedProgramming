1. INCLUDED

Source files and Eclipse archive
Usability study
Video

2. HOW TO RUN THE FILE

Unzip the archive file. Use the command line to go to through the following file path:
	AdvancedProgramming/Water/bin

Once you are in the bin directory, run the following command:
	appletviewer waterHtml.html

The applet should then open in its own window

3. KNOWN PROBLEMS
None known

4. DESIGN
This program uses a model view controller template with a factory class to create view screens. The footprint, user, and bottle classes are all part of the model and appear on almost every screen. The user class and its associated footprint are passes back and forth between screens and the bottle is updated on each screen based on the user’s footprint. The control is a a screen driver and a card driver which contain action listeners for the next and previous buttons and move the user back and forth between the screen. The screen views are created in a factory.

5. DEVELOPMENT PROCESS
This program was designed using an agile development process that went through many different iterations.
