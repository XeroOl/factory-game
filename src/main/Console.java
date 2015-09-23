package main;

import java.io.PrintStream;

public class Console {
	public static Console console = new Console(System.out,Console.DEBUG);
	PrintStream myStream;
	public final static int DEBUG = 0;
	public final static int INFO = 1;
	public final static int WARN = 2;
	public final static int ERROR = 3;
	public final static int FATAL = 4;
	int level;
	public Console(PrintStream p,int level) {
		myStream=p;
		this.level=level;
	}
	public void print(String message, int level){
		if(this.level>level)return;
		switch(level){
		case DEBUG:
			myStream.println("[DEBUG] "+message);return;
		case INFO:
			myStream.println("[INFO] "+message);return;
		case WARN:
			myStream.println("[!WARN!] "+message);return;
		case ERROR:
			myStream.println("[!!ERROR!!] "+message);return;
		case FATAL:
			myStream.println("[!!!FATAL!!!] "+message);return;
		}
	}
}
