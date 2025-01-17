import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Simul_1063{
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        String[] move = new String[N];
        for (int i = 0; i < N; i++) {
            move[i] = br.readLine();
        }
 
        int kingPosX = kingPos.charAt(1) - '0';
        int kingPosY = kingPos.charAt(0) - 'A';
        int stonePosX = stonePos.charAt(1) - '0';
        int stonePosY = stonePos.charAt(0) - 'A';
 
        for (int i = 0; i < move.length; i++) {
            String str = move[i];
            switch (str) {
            case "R":
                if (kingPosY < 7) {
                    kingPosY++;
                    if (kingPosY == stonePosY && kingPosX == stonePosX) {
                        if (stonePosY < 7) {
                            stonePosY++;
                        }else {
                            kingPosY--;
                        }
                    }
                }
                break;
 
            case "L":
                if (kingPosY > 0) {
                    kingPosY--;
                    if (kingPosY == stonePosY && kingPosX == stonePosX) {
                        if (stonePosY > 0) {
                            stonePosY--;
                        }else {
                            kingPosY++;
                        }
                    }
 
                }
                break;
 
            case "B":
                if (kingPosX > 1) {
                    kingPosX--;
                    if (kingPosY == stonePosY && kingPosX == stonePosX) {
                        if (stonePosX > 1) {
 
                            stonePosX--;
                        }else {
                            kingPosX++;
                        }
                    }
                }
                break;
 
            case "T":
                if (kingPosX < 8) {
                    kingPosX++;
                    {
                        if (kingPosY == stonePosY && kingPosX == stonePosX) {
                            if (stonePosX < 8) {
                                stonePosX++;
                            }else {
                                kingPosX--;
                            }
                            
                        }
                    }
                }
                break;
 
            case "RT":
                if (kingPosX < 8  && kingPosY < 7 ) {
                    kingPosX++;
                    kingPosY++;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosX <8 && stonePosY <7) {
                            
                            stonePosX++;
                            stonePosY++;
                        }else {
                            kingPosX--;
                            kingPosY--;
                        }
                    }
                }
 
                break;
 
            case "LT":
                if (kingPosX < 8  && kingPosY > 0 ) {
                    kingPosX++;
                    kingPosY--;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosX < 8 && stonePosY >0) {
                            
                            stonePosX++;
                            stonePosY--;
                        }else {
                            kingPosX--;
                            kingPosY++;
                        }
                    }
                }
 
                break;
 
            case "RB":
                if (kingPosX > 1 && kingPosY < 7) {
                    kingPosX--;
                    kingPosY++;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosX >1 && stonePosY <7) {
                            stonePosX--;
                            stonePosY++;
                            
                        }else {
                            kingPosX++;
                            kingPosY--;
                        }
                    }
                }
                
                break;
 
            case "LB":
                if (kingPosY > 0  && kingPosX > 1 ) {
                    kingPosY--;
                    kingPosX--;
                    if(kingPosY == stonePosY && kingPosX == stonePosX) {
                        if(stonePosY>0 && stonePosX >1) {
                            stonePosY--;
                            stonePosX--;
                            
                        }else {
                            kingPosY++;
                            kingPosX++;
                        }
                    }
                }
 
                break;
 
            default:
                break;
            }
        }
        String kingStr = "";
        kingStr += (char) (kingPosY + 65);
        System.out.println(kingStr + kingPosX);
        String stoneStr = "";
        stoneStr += (char) (stonePosY + 65);
        System.out.println(stoneStr + stonePosX);
    }// end of main
}// end of class