import java.io.File;

public class _8_NestedFolders {//fail judge

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File f = new File(userDir + "/Files-and-Streams");
        int[] count=new int[1];
        DFS(f,count);
        System.out.printf("[%d] forlders",count[0]);


    }

    static void DFS(File root,int[] count) {
        if (root == null) {
            return;
        }
        File[] files=root.listFiles();
        for (File file : files) {
            if(file.isDirectory()){
                count[0]=count[0]+1;
                System.out.println(file.getName());
                DFS(file,count);
            }/*else{
                System.out.println(file.getName());
            }*/
        }
    }
}
