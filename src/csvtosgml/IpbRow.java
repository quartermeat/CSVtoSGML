/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtosgml;

/**
 *
 * @author jeremy.williamson
 */
public class IpbRow {

    //columns
    private String figureAndIndex;
    private String partNumber;
    private String cageCode;
    private String nomenclature;
    private String unitsEach;
    private String usableOnCode;
    private String smrCode;
    private int previousRowPlCode;
    private int nextRowPlCode;
    private int plCode;

    //Constructors
    public IpbRow() {

    }//end part()

    //test constructor
    public IpbRow(String testNomenclature) {
        nomenclature = testNomenclature;
    }//end part()

    
    public static int computePlCode(String nomenclature){
        System.out.println(nomenclature);
        
        int plCode = 0;
        char testChar = nomenclature.charAt(0);

        int i = 0;
        while (testChar == '.' || testChar == ' ') {
            testChar = nomenclature.charAt(i);
            if (testChar == '.') {
                plCode++;
            }
            i++;
        }//end for
        
        return plCode;
    }
    
    //methods
    public void initializePlCode() {
        char testChar = nomenclature.charAt(0);
        plCode = 0;

        int i = 0;
        while (testChar == '.' || testChar == ' ' || testChar == '�') {
            testChar = nomenclature.charAt(i);
            if (testChar == '.') {
                plCode++;
            }else if(testChar =='�'){
                plCode = plCode + 3;
            }
            i++;
        }//end for
    }//end initializePlCode()

    public void setColumnData(String data, int column) {

        switch (column) {
            case 1: {
                setFigureAndIndex(data);
                break;
            }
            case 2: {
                setPartNumber(data);
                break;
            }
            case 3: {
                setCageCode(data);
                break;
            }
            case 4: {
                setNomenclature(data);
                break;
            }
            case 5: {
                setUnitsEach(data);
                break;
            }
            case 6: {
                setUsableOnCode(data);
                break;
            }
            case 7: {
                setSmrCode(data);
                break;
            }
            case 8: {
                previousRowPlCode = Integer.valueOf(data);
                break;
            }
        }//end switch
    }//end setColumnData

    public void printRowToScreen() {
        System.out.print(getPlCode());
        System.out.print(getFigureAndIndex());
        System.out.print(getPartNumber());
        System.out.print(getCageCode());
        System.out.print(getNomenclature());
        System.out.print(getUnitsEach());
        System.out.print(getUsableOnCode());
        System.out.print(getSmrCode());
        System.out.print(previousRowPlCode + "\n");
    }

    public int getPlCode() {
        return plCode;
    }

    public String getFigureAndIndex() {
        if (figureAndIndex == null) {
            return "";
        } else {
            return figureAndIndex;
        }//end if/else
    }//end getFigureAndIndex()

    public void setFigureAndIndex(String figureAndIndex) {
        this.figureAndIndex = figureAndIndex;
    }

    public String getPartNumber() {
        if (partNumber == null) {
            return "";
        } else {
            return partNumber;
        }//end if/else
    }//end getPartNumber()

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getCageCode() {
        if (cageCode == null) {
            return "";
        } else {
            return cageCode;
        }//end if/else
    }//end getCageCode()

    public void setCageCode(String cageCode) {
        this.cageCode = cageCode;
    }

    public String getNomenclature() {
        if (nomenclature == null) {
            return "";
        } else {
            return nomenclature;
        }//end if/else
    }//end getNomenclature()

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
        //set the plCode based on the number of dots preceding the nomenclature
        initializePlCode();
        //AFTER initializing plCode, delete dots
        this.nomenclature = this.nomenclature.replaceAll("II", "I");
        //delete weird character artifact produced after going from ascii to unicode
        this.nomenclature = this.nomenclature.replaceAll("�", "");
        //delete periods in string
        this.nomenclature = this.nomenclature.replaceAll("\\.", "");        
        //delete space before and after string
        this.nomenclature = this.nomenclature.trim();
        //delete space after string
        //this.nomenclature = this.nomenclature.replaceAll("s/\\s+$//;", "");
    }

    public String getUnitsEach() {
        if (unitsEach == null) {
            return "";
        } else {
            return unitsEach;
        }//end if/else
    }

    public void setUnitsEach(String unitsEach) {
        this.unitsEach = unitsEach;
    }

    public String getUsableOnCode() {
        if (usableOnCode == null) {
            return "";
        } else {
            return usableOnCode;
        }//end if/else
    }

    public void setUsableOnCode(String usableOnCode) {
        this.usableOnCode = usableOnCode;
    }

    public String getSmrCode() {
        if (smrCode == null) {
            return "";
        } else {
            return smrCode;
        }//end if/else
    }

    public void setSmrCode(String smrCode) {
        this.smrCode = smrCode;
    }
    
    public int getPreviousRowPlCode(){
        return previousRowPlCode;
    }
    
    public void setNextRowPlCode(int nextRowPlCode){
        this.nextRowPlCode = nextRowPlCode;
    }
    
    public int getNextRowPlCode(){
        return nextRowPlCode;
    }

}//end IpbRow
