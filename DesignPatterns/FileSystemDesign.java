public class FileSystemDesign {

    public static void main(String []args){

        Directory d1 = new Directory(null,"dir1");
        Directory d2 = new Directory(d1,"dir2");

        d1.addEntry(d2);
        d1.addEntry(new File(10,d1,"f2"));
//        File f2 = new File(10,d1,"f2");
        d2.addEntry(new File(15,d2,"f1"));
        d2.addEntry(new File(10,d2,"f3"));

//        File f1 = new File(10,d2,"f1");
//        File f3 = new File(10,d2,"f3");

        System.out.println(d1.size());


    }

}

abstract class Entry {

    protected Directory parent;
    protected long modifiedDate;
    protected long createDate;
    protected String name;

    public boolean delete(){
        if(parent == null) return false;
        return parent.deleteEntry(this);
    }

    abstract int size();

    Entry(String name,Directory p) {
        this.name = name;
        this.parent = p;
        this.modifiedDate = System.currentTimeMillis();
        this.createDate = System.currentTimeMillis();
    }

    public String getFullPath() {

        if(parent == null) return name;
        return parent.getFullPath() + "/" + name;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class File extends Entry {

    private String content;
    private int size;

    public File(int size,Directory p,String n) {
        super(n,p);
        this.size = size;
    }

    public int size() {return  size;}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Directory extends Entry {

    protected List<Entry> entries;

    public Directory(Directory p,String n) {
        super(n,p);
        entries = new ArrayList<>();
    }

    public int size() {

        int s=0;
        for(Entry e:entries) {
            s+=e.size();
        }
        return s;
    }

    public int getNumberOfFiles() {

        int cnt = 0;

        for(Entry entry:entries) {

           if(entry instanceof File){
               cnt++;
           } else if(entry instanceof Directory) {
               cnt++;
               Directory d = (Directory) entry;
               cnt += d.getNumberOfFiles();
           }
        }
        return cnt;
    }

    public boolean deleteEntry(Entry entry) {
        return entries.remove(entry);
    }

    public boolean addEntry(Entry entry) {
        return entries.add(entry);
    }

    public List<Entry> getEntries() {
        return entries;
    }
}

