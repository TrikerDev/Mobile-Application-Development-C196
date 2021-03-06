package TJRiker.WGUScheduler.model;

import android.os.Parcel;
import android.os.Parcelable;

import TJRiker.WGUScheduler.data.DBHelper;

public class Course implements Parcelable {
    private long id;
    private String title;
    private long startDate;
    private long endDate;
    private String status;
    private String mentorName;
    private String mentorPhone;
    private String mentorEmail;
    private String notes;
    private long termId;
    private int startId;
    private int endId;

    public long getId() { return id; }
    public String getTitle() { return title; }
    public long getStart() { return startDate; }
    public String getStartDisplay() { return DBHelper.timestampToString(startDate); }
    public long getEnd() { return endDate; }
    public String getEndDisplay() { return DBHelper.timestampToString(endDate); }
    public String getStatus() { return status; }
    public String getMentorName() { return mentorName; }
    public String getMentorPhone() { return mentorPhone; }
    public String getMentorEmail() { return mentorEmail; }
    public String getNotes() { return notes; }
    public long getTermId() { return termId; }
    public int getStartId() { return startId; }
    public int getEndId() { return endId; }
    public String getStartMessage() { return "Start course " + title + " on " + getStartDisplay(); }
    public String getEndMessage() { return "End course " + title + " on " + getEndDisplay(); }

    public void setId(long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setStart(long startDate) { this.startDate = startDate; }
    public void setEnd(long endDate) { this.endDate = endDate; }
    public void setStatus(String status) { this.status = status; }
    public void setMentorName(String mentorName) { this.mentorName = mentorName; }
    public void setMentorPhone(String mentorPhone) { this.mentorPhone = mentorPhone; }
    public void setMentorEmail(String mentorEmail) { this.mentorEmail = mentorEmail; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setTermId(long termId) { this.termId = termId; }
    public void setStartId(int startId) { this.startId = startId; }
    public void setEndId(int endId) { this.endId = endId; }

    public Course() {}

    public Course(long id, String title, long startDate, long endDate, String status,
            String mentorName, String mentorPhone, String mentorEmail, String notes,
            long termId, int startId, int endId) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
        this.notes = notes;
        this.termId = termId;
        this.startId = startId;
        this.endId = endId;
    }

    public Course(Parcel source) {
        this.id = source.readLong();
        this.title = source.readString();
        this.startDate = source.readLong();
        this.endDate = source.readLong();
        this.status = source.readString();
        this.mentorName = source.readString();
        this.mentorPhone = source.readString();
        this.mentorEmail = source.readString();
        this.notes = source.readString();
        this.termId = source.readLong();
        this.startId = source.readInt();
        this.endId = source.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeLong(startDate);
        dest.writeLong(endDate);
        dest.writeString(status);
        dest.writeString(mentorName);
        dest.writeString(mentorPhone);
        dest.writeString(mentorEmail);
        dest.writeString(notes);
        dest.writeLong(termId);
        dest.writeInt(startId);
        dest.writeInt(endId);
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }

        @Override
        public Course createFromParcel(Parcel source) {
            return new Course(source);
        }
    };

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Course)) {
            return false;
        }

        Course course = (Course) o;
        return course.id == id;
    }
}
