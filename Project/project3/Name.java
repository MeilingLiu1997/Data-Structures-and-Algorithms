/**
	This class is going to:
		Set input Name case not be sensitive

	@ Author Meiling Liu
**/

public class Name{
	// data memeber
	private String[] inputName;
	
	// constructor
	public Name(String[] inputName){
		this.inputName = inputName;
	}

	// method
	public String toString(){
		String result = inputName[0] + " ";
		for(int i = 1; i < inputName.length-1; i++){
			result += inputName[i].substring(0,1).toLowerCase()
						+inputName[i].substring(1) + " ";
		}
		result += inputName[inputName.length-1];
		return result;
	}

}