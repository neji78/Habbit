import java.util.ArrayList;
import java.util.UUID;

public class routine_item {
    public UUID getM_id() {
        return m_id;
    }

    private UUID m_id;

    public String getM_routine_name() {
        return m_routine_name;
    }

    public void setM_routine_name(String m_routine_name) {
        this.m_routine_name = m_routine_name;
    }

    public String getM_routine_description() {
        return m_routine_description;
    }

    public void setM_routine_description(String m_routine_description) {
        this.m_routine_description = m_routine_description;
    }

    public int getM_times() {
        return m_times;
    }

    public void setM_times(int m_times) {
        this.m_times = m_times;
    }

    private String m_routine_name;
    private String m_routine_description;
    private int m_times;
    private ArrayList<Boolean> m_done;
    public void routine_item()
    {
        m_id = UUID.randomUUID();
        m_done = new ArrayList<Boolean>(7);
        for (int i = 0; i < 7; i++) {
            m_done.set(i, false);
        }
    }
    public void setField(int i,boolean ans)
    {
        m_done.set(i,ans);
    }
    public boolean getField(int i)
    {
        return m_done.get(i);
    }
}
