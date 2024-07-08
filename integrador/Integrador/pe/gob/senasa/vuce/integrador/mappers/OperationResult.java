package pe.gob.senasa.vuce.integrador.mappers;

public enum OperationResult {
	Success (1),
	Failure (0),
	PckgError (-1);
	
	private final int value;
	
	OperationResult(int value) {
        this.value = value;
    }
	
	public double value()   { return value; }
	
	public static OperationResult getResult(Double result)
	{
		if (result > 0)
		{
			return Success;
		}
		else if (result == 0)
		{
			return Failure;
		}
		else
		{
			return PckgError;
		}
		
	}
}
