# ClipBoard Image to base64 (CBI64)
## About
This is a JVM utility application for converting images into DataURL (Base64) form.

Simply copy the targeted image from your browser or whatever software you use and then run this application, 
a data url representing your image will be placed inside your system's clipboard.

Copying pictures from Explorer/Finder will not work, as they are files not pictures (but you can get their icons this way somehow).

## Install

Download the jar file under `target` directory.

## Run

**First, regardless of OS, make sure you have Java installed and its version is at least 17.**

For Windows users, that's it. Click the jar file and it will run. I do suggest you to add it to your `PATH` though, so you can launch it from your terminal. If you do not know what `PATH` is, unfortunately I do not have time nor space to explain it here; google it.

---

For MacOS users, run this in your terminal:

```bash
mkdir ~/cbi64/
```

Suppose your downloaded jar file is in Downloads folder, run this in your terminal next:

```bash
mv ~/downloads/cbi64.jar ~/cbi64/
```

And then, run this in your terminal:

```bash
vim /usr/local/bin/cbi64
```

Press `i` and then type in the following text:

```bash
#! /bin/bash
java -jar ~/cbi64/cbi64.jar
```

Then press escape, and then type `:wq` and enter. If the terminal didn't go back to what it was in the beginning, google "how to exit vim" for further instructions.

Last, type this in the terminal:

```bash
chmod 754 /usr/local/bin/cbi64
```

You are all set now, type `cbi64` in the terminal to launch the application.

---

If you are Linux user, you probably know better than I do.

## Q&As

- Q: Why?
  A: I use [Typora](https://typora.io/) for notes and documentations, and sometimes I need to insert images. And since I want my markdown files to be standalone, the pictures' URL must be in DataURL form. For images downloaded (files), of course I can just use those countless online tools out there, but if I'm copying images from the web or from Discord, I'm just too lazy to download and upload and download it again.
- Q: Will it support converting files in the future?
  A: Maybe, if I found out I need to. But I doubt it as you (and I as will) can just use other tools (mentioned above).
- Q: Will it support the counter-process in the future?
  A: Same as question#2.

## Easter Egg

If you know Kotlin, check out my code XD.