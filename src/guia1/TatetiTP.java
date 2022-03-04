package guia1;

import java.util.Scanner;

public class TatetiTP {
	public static void main(String[] args) {

		char tablero[][] = new char[3][3];

		System.out.println("Ta-Te-Ti");
		inicializarTablero(tablero);
		mostrarTateti(tablero);
		ganadorColumna(tablero);
		ganadorDiagonal(tablero);

		int cantidad = 0;
		boolean fichaX = true;
		Scanner sc = new Scanner(System.in);

		while (cantidad < 9 && !ganadorFila(tablero) && !ganadorColumna(tablero) && !ganadorDiagonal(tablero)) {
			char ficha = 'O';
			if (fichaX) {
				ficha = 'X';

			}
			System.out.println(" TURNO: JUGADOR " + ficha);
			System.out.println("Ingrese la coordenada para la fila que desea ocupar : ");

			int coordenada1 = sc.nextInt();
			System.out.println("Ingrese la coordenada para la columna que desea ocupar : ");
			int coordenada2 = sc.nextInt();

			if (tablero[coordenada1][coordenada2] == '-') {

				tablero[coordenada1][coordenada2] = ficha;

				mostrarTateti(tablero);

				cantidad++;

				fichaX = !fichaX;

			} else {
				System.out.println("La celda esta ocupada");

			}

		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				System.out.print(tablero[i][j]);

			}
			System.out.println();

		}
	}

	private static boolean ganadorDiagonal(char[][] matriz) {

		boolean ganador = false;

		for (int fila = 0; fila < 3; fila++) {

			if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[fila][0] != '-'
					&& matriz[2][0] != '-' && matriz[0][2] != '-') {

				if (matriz[fila][0] == 'X') {
					System.out.println("gana jugador X");

				} else {
					System.out.println("gana jugador O");
				}

				ganador = true;
			}
		}

		return ganador;

	}

	private static boolean ganadorColumna(char[][] matriz) {
		boolean ganador = false;

		for (int columna = 0; columna < 3; columna++) {

			if (matriz[columna][0] == matriz[columna][1] && matriz[columna][1] == matriz[columna][2]
					&& matriz[columna][0] != '-' && matriz[columna][1] != '-' && matriz[columna][2] != '-') {

				if (matriz[columna][0] == 'X') {
					System.out.println("gana jugador X ");

				} else {
					System.out.println("gana jugador O ");
				}

				ganador = true;
			}
		}

		return ganador;

	}

	private static boolean ganadorFila(char[][] matriz) {

		boolean ganador = false;

		for (int fila = 0; fila < 3; fila++) {

			if (matriz[fila][0] == matriz[fila][1] && matriz[fila][1] == matriz[fila][2] && matriz[fila][0] != '-'
					&& matriz[fila][1] != '-' && matriz[fila][2] != '-') {

				if (matriz[fila][0] == 'X') {
					System.out.println("gana jugador X ");

				} else {
					System.out.println("gana jugador O ");
				}

				ganador = true;
			}
		}

		return ganador;
	}

	private static void mostrarTateti(char matriz[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				System.out.print("[" + matriz[i][j] + "]");
			}
			System.out.println();

		}

	}

	private static void inicializarTablero(char[][] matriz) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				matriz[i][j] = '-';
			}

		}

	}
}
