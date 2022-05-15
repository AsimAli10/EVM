
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class dataBase {
	
	public int checkLogin(String username, String password) throws IOException {
		
		
		String fileName = "src\\application\\voters.csv";
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
			String string=array2D[0][col];
			string = string.replaceAll("^\"|\"$", "");
			String string2=array2D[1][col];
			string2 = string2.replaceAll("^\"|\"$", "");
		        if(string.equals(username)&&(string2.equals(password)))
		        {
		        	//System.out.println("bshcgbjh");
		        	return 2;
		        }
		        	
		    }
		
		return 0;
		
		
	}
	private String checkinNadra(String cnic, String password) throws IOException
	{
		
		String fileName = "src\\application\\NADRA.csv";
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
					FileWriter fw = new FileWriter("src\\application\\voters.csv", true);
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
		
		String fileName = "src\\application\\voters.csv";
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
		String fileName = "src\\application\\banedCandidates.csv";
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
		String fileName = "src\\application\\candidates.csv";
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
		String str= candidate.getName()+","+candidate.getId()+","+candidate.getGroup()+",0";
		FileWriter fw = new FileWriter("src\\application\\candidates.csv", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(str);
	    bw.newLine();
	    bw.close();
		return true;
	}
	public boolean checkVotingStatus(String cnic) throws IOException {
		
		String fileName = "src\\application\\voters.csv";
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
			
			
			String string=array2D[0][col];
			string = string.replaceAll("^\"|\"$", "");
			String string2=array2D[3][col];
			string2 = string2.replaceAll("^\"|\"$", "");
			//System.out.println(string2);
		        if(string.equals(cnic) && string2.equals("0") )
		        {
		        	return true;
		        }
		        	
		    }
		
		return false;
	}
	
	
	private boolean updateVotingStatus(String cnic) throws IOException {
        File inputFile = new File("src\\application\\voters.csv");

        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        for(int i=0; i<csvBody.size(); i++){
            String[] strArray = csvBody.get(i);
            for(int j=0; j<strArray.length; j++){
                if(strArray[j].equalsIgnoreCase(cnic)){ //String to be replaced
                    csvBody.get(i)[3] = "1"; //Target replacement
                    break;
                }
            }
        }
        reader.close();

        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
        return true;
    }
	private boolean updatecandidatevotecount(String candidateid) throws IOException {
		File inputFile = new File("src\\application\\candidates.csv");

        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        for(int i=0; i<csvBody.size(); i++){
            String[] strArray = csvBody.get(i);
            for(int j=0; j<strArray.length; j++){
                if(strArray[j].equalsIgnoreCase(candidateid)){ //String to be replaced
                    int votes=Integer.parseInt(csvBody.get(i)[3]); //Target replacement
                    votes+=1;
                    csvBody.get(i)[3]=Integer.toString(votes);
                    break;
                }
            }
        }
        reader.close();

        // Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
        return true;
		
	}
	public boolean castVote(String voterid, String candidateid) throws IOException {
		
		return updateVotingStatus(voterid) && updatecandidatevotecount(candidateid);
	}
public String getCandidates() throws IOException {
		
		
		File inputFile = new File("src\\application\\candidates.csv");

        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        String content = new String();
        content="Name        \tID                 \tGroup\n";
        for(int i=0; i<csvBody.size(); i++){
            String[] strArray = csvBody.get(i);
            for(int j=0;j<strArray.length-1;j++) {
            	
            	content+=strArray[j];
            	if(j==0)
            		content+="	";
            	content+="	";
            }
            content+="\n";
            content=content.replace('"', '\0');
    		content=content.replaceAll(",","	");
        }
		
		return content;
	}
	public Candidate checkWinner() throws IOException {
		File inputFile = new File("src\\application\\candidates.csv");

        // Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
        String[] WinnerArray = null;
        int maxvotes=0;
        boolean check=false;
        List<String[]> csvBody = reader.readAll();
        // get CSV row column and replace with by using row and column
        for(int i=0; i<csvBody.size(); i++){
            String[] strArray = csvBody.get(i);
         
                    int votes=Integer.parseInt(csvBody.get(i)[3]); //Target replacement
                    if(votes==maxvotes&&maxvotes!=0)
                    {
                    	i++;
                    	check=false;
                    	continue;
                    }
                    if(votes>maxvotes)
                    {
                    	check=true;
                    	maxvotes=votes;
                    	WinnerArray=strArray;
                    	
                    }
                    	
        }
        if(check==false)
        	return null;
        reader.close();
        Candidate c=new Candidate(WinnerArray[0],WinnerArray[1],WinnerArray[2]);
        c.setVotes(maxvotes);
		return c;
	}
	
	
	

}

