public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int position = 1;
        for(int i =1;i<9;i++){
            if(shot.endsWith(String.valueOf(i))){
                break;
            }
            position +=8;
        }
        for(char ch = 'A'; ch<'I';ch++){
            if(shot.indexOf(ch)!=-1)break;
            position++;
        }
        boolean flag = ("0".repeat(Long.numberOfLeadingZeros(ships)) + Long.toBinaryString(ships)).charAt(position - 1) == '1';
        shots = shots|(0b1L<<position-1);

        return flag;
    }

    public String state() {
        String map = "0".repeat(Long.numberOfLeadingZeros(ships)) + Long.toBinaryString(ships);
        StringBuilder shotsBuilder = new StringBuilder("0".repeat(Long.numberOfLeadingZeros(shots)) + Long.toBinaryString(shots));
        shotsBuilder.reverse();
        StringBuilder builder = new StringBuilder();
        for(int i =1;i<=map.length();i++){
            if (map.charAt(i - 1) == '1' && shotsBuilder.charAt(i-1) == '1') builder.append("☒");
            else if (map.charAt(i - 1) == '1' && shotsBuilder.charAt(i-1) == '0') builder.append("☐");
            else if (map.charAt(i - 1) == '0' && shotsBuilder.charAt(i-1) == '1') builder.append("×");
            else builder.append(".");

            if(i%8==0)builder.append('\n');
        }

        return new String(builder);
    }

    public static void main(String[] args) {
        long map = 0b11110000_00000111_00000000_00110000_00000010_01000000_00000000_00000000L;
        Battleship8x8 battleship8x8 = new Battleship8x8(map);
        System.out.println(battleship8x8.state());
        battleship8x8.shoot("A1");
        System.out.println(battleship8x8.state());
    }
}
