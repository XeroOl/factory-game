package main;

import java.io.PrintStream;

public class Console {
	public static Console console = new Console(System.out, Console.DEBUG);
	PrintStream myStream;
	public final static int DEBUG = 0;
	public final static int INFO = 1;
	public final static int WARN = 2;
	public final static int ERROR = 3;
	public final static int FATAL = 4;
	int level;

	public Console(PrintStream p, int level) {
		myStream = p;
		this.level = level;
	}
	public void debug(Object o) {
		debug(o.toString());
	}
	public void debug(String message) {
		if (level > DEBUG)
			return;
		myStream.println("[DEBUG] " + message);
	}
	public void info(Object o) {
		info(o.toString());
	}
	public void info(String message) {
		if (level > INFO)
			return;
		myStream.println("[INFO] " + message);
	}
	public void warn(Object o) {
		warn(o.toString());
	}
	public void warn(String message) {
		if (level > WARN)
			return;
		myStream.println("[INFO] " + message);
	}
	public void error(Object o) {
		error(o.toString());
	}
	public void error(String message) {
		if (level > ERROR)
			return;
		myStream.println("[!!ERROR!!] " + message);
	}
	public void fatal(Object o) {
		fatal(o.toString());
	}
	public void fatal(String message) {
		if (level > FATAL)
			return;
		myStream.println("[!!!FATAL!!!] " + message);
	}
}
