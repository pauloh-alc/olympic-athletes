package model;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class AthleteTableModel extends AbstractTableModel {
    private List<OlympicAthlete> athletes;
    private List<String> columns;

    public AthleteTableModel(List<OlympicAthlete> athletes) {
        this.athletes = athletes;
        this.columns = Arrays.asList("Id","Name", "Age", "Sex", "Committee", "Sport", "Gold", "Silver", "Bronze");
    }

    @Override
    public int getColumnCount() {
    	return columns.size();
    }

    @Override
    public int getRowCount() {
    	return athletes.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OlympicAthlete athlete_temp = athletes.get(rowIndex);
        
        switch (columnIndex) {
        	case 0:
                return athlete_temp.getId();

            case 1: 
                return athlete_temp.getName();
     
            case 2:
                return athlete_temp.getAge();
                
            case 3:
                return athlete_temp.getSex();
                
            case 4:
                return athlete_temp.getCommittee();
                
            case 5:
                return athlete_temp.getSport();
                
            case 6:
                return athlete_temp.getMedals().get(0);
               
            case 7:
                return athlete_temp.getMedals().get(1);
               
            case 8:
                return athlete_temp.getMedals().get(2); 
            default:
            	throw new IllegalArgumentException("..." + columnIndex);
        }
    }
    
    @Override
    public String getColumnName(int i) {
    	return columns.get(i);
    }  
}