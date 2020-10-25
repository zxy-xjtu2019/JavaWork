import java.awt.Font;
import java.util.Random;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class App {
    public static void main(String[] args) throws Exception {
        long[] data1 = new long[10050];
        long[] data2 = new long[10050];
        for(int i = 100;i<=10000;i+=100){
            long starttime = System.nanoTime();
            get_sort_r(i);
            long endtime1 = System.nanoTime();
            get_sort_l(i);
            long endtime2 = System.nanoTime();
            data1[i] = endtime1 - starttime;
            data2[i] = endtime2 - endtime1;
            System.out.println("已完成！"+i);
        }
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);		
        XYSeriesCollection mCollection = GetCollection(data1,data2);
        JFreeChart mChart = ChartFactory.createXYLineChart(
            "直接插入算法时间统计",
            "直接插入算法",
            "time",				
            mCollection,
            PlotOrientation.VERTICAL,
            true, 
            true, 
            false);
        ChartFrame mChartFrame = new ChartFrame("图1", mChart);
        mChartFrame.pack();
        mChartFrame.setVisible(true);
    }
    
    private static XYSeriesCollection GetCollection(long[] data1,long[] data2) {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries mSeriesr = new XYSeries("正序");
        for(int i=100;i<=10000;i+=100)mSeriesr.add(i, data1[i]);
        XYSeries mSeriesb = new XYSeries("逆序");
        for (int i = 100; i <= 10000; i+=100) mSeriesb.add(i, data2[i]);
        xySeriesCollection.addSeries(mSeriesr);
        xySeriesCollection.addSeries(mSeriesb);
        return xySeriesCollection;
    }

    public static void get_sort_r(int n) {
        int[] a = new int[n+10];
        for(int i=0;i<a.length;i++)a[i] = i;
        straight_insertion_sort(a);
    }
    public static void get_sort_l(int n) {
        int[] a = new int[n+10];
        for(int i=0;i<a.length;i++)a[i] = a.length-i;
        straight_insertion_sort(a);
    }

    // 每一个算法都传入一个数据完整的int 数组
    public static void straight_insertion_sort(int[] a) {
        int[] b = new int[100010];
        b[0] = a[0];
        int len = 1;
        for(int i = 1;i<a.length;i++){
            int x = a[i];
            for(int j=0;j<len;j++){
                if(b[j]>x){
                    for(int k = len;k>j;k--)b[k] = b[k-1];
                    b[j] = x;
                }
            }
            len++;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        return;
    }

    public static void simple_chose(int[] a) {
        for(int i = 0;i<a.length;i++){
            int minl = 0x7ffff,k=i;
            for(int j = i;j<a.length;j++){
                if(a[j]<minl){
                    k = j;
                    minl = a[j];
                }
            }
            a[k] = a[i];
            a[i] = minl;
        }
    }
    
    public static void bubble_sort(int[] a) {
        int len = a.length - 1,temppostion = 0;
        for(int i = 0 ;i< a.length - 1;i++){
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                    temppostion = j;
                }
            }
            len = temppostion; // 最后一次交换位置，之后位置已经排序完毕
            if(flag == true) return;//不交换，则已经排序完毕
        }
    }

    public static void quick_sort(int[] a, int l,int r) {
        if(l<r){
            int i = l,j = r, x = a[l];
            while(i<j){
                while(i<j && a[j]>=x)j--;
                if(i<j) a[i++] = a[j];
                while(i<j && a[i]<x)i++;
                if(i<j) a[j--] = a[i];
            }
            a[i] = x;
            quick_sort(a, l, i-1);
            quick_sort(a, i+1, r);
        }
        return;
    }

    public static void merge_sort(int[] a,int l,int r) {
        int mid = (l+r)>>1;
        if(l<r){
            merge_sort(a, l, mid);
            merge_sort(a, mid+1, r);
            merage_sort_detail(a,l,mid,r);
        }
    }
    public static void merage_sort_detail(int[] a,int l, int mid,int r) {
        int[] temp = new int[r-l+10];
        int i = l, j = mid+1,k = 0;
        while(i<j){
            while(i<j&&j<=r){
                if(a[j]<a[i])temp[k++] = a[j++];
                else temp[k++] = a[i++];
            }
        }
        while(i<=mid) temp[k++] = a[i++];
        while(j<=r) temp[k++] = a[j++];
        while(k!=-1) a[l+k] = temp[k--];

    }
}
