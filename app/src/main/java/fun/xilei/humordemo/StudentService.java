package fun.xilei.humordemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StudentService extends Service {
    private final String TAG = "StudentService";
    private static IUpdateLayout mIUpdateLayout = null;
    private ArrayList<Student> mStudents = new ArrayList<>();
    private IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void addStudent(final Student student) throws RemoteException {
            Log.d(TAG, "addStudent " + student.toString());
            mStudents.add(student);
            notifyUpdate();
        }

        @Override
        public List<Student> getCurrentStudents() throws RemoteException {
            return mStudents;
        }
    };

    public static void setListener(IUpdateLayout listener) {
        mIUpdateLayout = listener;
    }

    private void notifyUpdate() {
        if (mIUpdateLayout != null) {
            mIUpdateLayout.showText(mStudents.toString());
        }
    }

    public StudentService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public interface IUpdateLayout{
        void showText(String text);
    }
}
