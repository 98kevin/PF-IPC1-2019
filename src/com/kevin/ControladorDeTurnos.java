package com.kevin;

import java.util.Random;

public class ControladorDeTurnos {
	public static boolean isTurno() {
		return new Random().nextBoolean();
	}
}
