public class Marks {
    private int sid;
    private int physicsMarks;
    private int chemistryMarks;
    private int mathsMarks;

    public Marks(int id,int physics, int chemistry, int maths) {
        this.sid= id;
        this.physicsMarks = physics;
        this.chemistryMarks = chemistry;
        this.mathsMarks = maths;
    }

    public int getSid(){
        return sid;
    }

    public void setSid(int id){
        this.sid = id;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(int physics) {
        this.physicsMarks = physics;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(int chemistry) {
        this.chemistryMarks = chemistry;
    }

    public int getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(int maths) {
        this.mathsMarks = maths;
    }
}
