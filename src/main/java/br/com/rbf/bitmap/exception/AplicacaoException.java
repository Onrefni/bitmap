package br.com.rbf.bitmap.exception;

public class AplicacaoException extends Exception {
	
	private static final long serialVersionUID = 455220141950907654L;

	public AplicacaoException() {
		super();
	}

	public AplicacaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AplicacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AplicacaoException(String message) {
		super(message);
	}

	public AplicacaoException(Throwable cause) {
		super(cause);
	}

}
