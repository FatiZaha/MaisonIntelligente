package metier.LesExceptions;

public class PaiementException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public PaiementException(String message) {
			super(message);
		}
}

