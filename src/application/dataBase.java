package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dataBase {
	
	public int checkLogin(String username, String password) throws IOException {
		
		
		String fileName = "C:\\Users\\bbl\\git\\EVM\\src\\application\\voters.csv";
		List<List<String>> list = new ArrayList<List<String>>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String[] headers = line.split(",");
		for(String header: headers) {
		    List<String> subList = new ArrayList<String>();
		    subList.add(header);
		    list.add(subList);
		}
		while((line = br.readLine()) != null) {
		    String[] elems = line.split(",");
		    for(int i = 0; i < elems.length; i++) {
		        list.get(i).add(elems[i]);
		    }
		}
		br.close();
		int rows = list.size();
		int cols = list.get(0).size();
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = list.get(row).get(col);
		    }
		} 
		
		for(int col = 0; col < cols; col++) {
		        if(array2D[0][col].equals(username)&&(array2D[1][col].equals(password)))
		        {
		        	return 2;
		        }
		        	
		    }
		
		return 0;
		
		
	}
	private String checkinNadra(String cnic, String password) throws IOException
	{
		
		String fileName = "C:\\Users\\bbl\\git\\EVM\\src\\application\\NADRA.csv";
		List<List<String>> list = new ArrayList<List<String>>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String[] headers = line.split(",");
		for(String header: headers) {
		    List<String> subList = new ArrayList<String>();
		    subList.add(header);
		    list.add(subList);
		}
		while((line = br.readLine()) != null) {
		    String[] elems = line.split(",");
		    for(int i = 0; i < elems.length; i++) {
		        list.get(i).add(elems[i]);
		    }
		}
		br.close();
		int rows = list.size();
		int cols = list.get(0).size();
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = list.get(row).get(col);
		    }
		} 
		
		for(int col = 0; col < cols; col++) {
		        if(array2D[3][col].equals(cnic))
		        	return array2D[3][col]+","+password+","+array2D[4][col]+",0";
		    }
		
		return null;
	}
	public int RegisterNewUser(String username, String cNIC, String password) throws IOException {
		
			Boolean b=this.checkinVoters(cNIC);
			
			if(b==true)
			{
				
				return 1;
			}
			else {
				String row=this.checkinNadra(cNIC,password);
				if(row!=null)
				{
					FileWriter fw = new FileWriter("C:\\Users\\bbl\\git\\EVM\\src\\application\\voters.csv", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    bw.write(row);
				    bw.newLine();
				    bw.close();
					return 2;
				}
			}
			
			return 0;
	}
	private boolean checkinVoters(String cnic ) throws IOException
	{
		
		String fileName = "C:\\Users\\bbl\\git\\EVM\\src\\application\\voters.csv";
		List<List<String>> list = new ArrayList<List<String>>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String[] headers = line.split(",");
		for(String header: headers) {
		    List<String> subList = new ArrayList<String>();
		    subList.add(header);
		    list.add(subList);
		}
		while((line = br.readLine()) != null) {
		    String[] elems = line.split(",");
		    for(int i = 0; i < elems.length; i++) {
		        list.get(i).add(elems[i]);
		    }
		}
		br.close();
		int rows = list.size();
		int cols = list.get(0).size();
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = list.get(row).get(col);
		    }
		} 
		
		for(int col = 0; col < cols; col++) {
		        if(array2D[0][col].equals(cnic))
		        {
		        	
		        	return true;
		        }
		        	
		    }
		
		return false;
	}
	public boolean checkNotAllowedCandidate(Candidate c) throws IOException {
		String fileName = "C:\\Users\\bbl\\git\\EVM\\src\\application\\banedCandidates.csv";
		List<List<String>> list = new ArrayList<List<String>>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String[] headers = line.split(",");
		for(String header: headers) {
		    List<String> subList = new ArrayList<String>();
		    subList.add(header);
		    list.add(subList);
		}
		while((line = br.readLine()) != null) {
		    String[] elems = line.split(",");
		    for(int i = 0; i < elems.length; i++) {
		        list.get(i).add(elems[i]);
		    }
		}
		br.close();
		int rows = list.size();
		int cols = list.get(0).size();
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = list.get(row).get(col);
		    }
		} 
		
		for(int col = 0; col < cols; col++) {
		        if(array2D[3][col].equals(c.getId()))
		        	return false;
		    }
		
		return true;
	}
	public boolean checkExistingCandidate(Candidate c) throws IOException {
		String fileName = "C:\\Users\\bbl\\git\\EVM\\src\\application\\candidates.csv";
		List<List<String>> list = new ArrayList<List<String>>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		String[] headers = line.split(",");
		for(String header: headers) {
		    List<String> subList = new ArrayList<String>();
		    subList.add(header);
		    list.add(subList);
		}
		while((line = br.readLine()) != null) {
		    String[] elems = line.split(",");
		    for(int i = 0; i < elems.length; i++) {
		        list.get(i).add(elems[i]);
		    }
		}
		br.close();
		int rows = list.size();
		int cols = list.get(0).size();
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = list.get(row).get(col);
		        
		    }
		} 
		
		for(int col = 0; col < cols; col++) {
			
				//System.out.println(array2D[0][col]);
		        if(array2D[1][col].equals(c.getId()))
		        {
		        	
		        	return false;
		        }
		        	
		    }
		
		return true;
	}
	public boolean registerCandidate(Candidate candidate) throws IOException {
		String str= candidate.getName()+","+candidate.getId()+","+candidate.getGroup();
		FileWriter fw = new FileWriter("C:\\Users\\bbl\\git\\EVM\\src\\application\\candidates.csv", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(str);
	    bw.newLine();
	    bw.close();
		return true;
	}

}

	
