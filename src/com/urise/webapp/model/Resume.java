package com.urise.webapp.model;

import java.util.*;

/**
 * com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    private final String fullName;

    private TextField personal;

    private TextField objective;

    private TextList achievement;

    private TextList qualifications;

    private TextList[] experience;

    private TextList[] education;

    private class TextField {
        String field;

        TextField(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    private class TextList {
        List<String> list = new ArrayList<>();

        TextList(String[] data) {
            List<String> list = new ArrayList<>();
            Collections.addAll(list, data);
            this.list = list;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (String text : list) {
                builder.append(text).append("\n");
            }
            return builder.toString();
        }
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    public String getUuid() {
        return uuid;
    }


    public String getFullName() {
        return fullName;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.getFullName());
        return cmp != 0 ? cmp : uuid.compareTo(o.getUuid());
    }

    /*public void setData(SectionType type, String... fields) {
        switch (type.name()) {
            case "PERSONAL":
                personal.field = fields[0];
                break;
            case "OBJECTIVE":
                objective.field = fields[0];
                break;
            case "ACHIEVEMENT":
                achievement.list.clear();
                Collections.addAll(achievement.list, fields);
                break;
            case "QUALIFICATIONS":
                qualifications.list.clear();
                Collections.addAll(qualifications.list, fields);
                break;
            case "EXPERIENCE":
                experience.period = fields[0];
                experience.organizationName = fields[1];
                experience.specialization = fields[2];
                experience.responsibility.addAll(Arrays.asList(fields).subList(3, fields.length));
                break;
            case "EDUCATION":
                education.period = fields[0];
                education.organizationName = fields[1];
                education.specialization = fields[2];
                education.responsibility.addAll(Arrays.asList(fields).subList(3, fields.length));
                break;
            default:
                throw new IllegalArgumentException(type.getTitle());
        }
    }

    public String[] getData(SectionType type) {
        switch (type.name()) {
            case "PERSONAL":
                return new String[]{personal.field};
            case "OBJECTIVE":
                return new String[]{objective.field};
            case "ACHIEVEMENT":
                String [] param=new String[achievement.list.size()];
                for (int i=0; i< param.length; i++){
                    param[i]=achievement.list.get(i);
                }
                return param;
            case "QUALIFICATIONS":
                //http://stackoverflow.com/questions/3293946/the-easiest-way-to-transform-collection-to-array
                return qualifications.list.toArray(new String[qualifications.list.size()]);
            case "EXPERIENCE":

            case "EDUCATION":

            default:
                throw new IllegalArgumentException(type.getTitle());
        }
    }*/

    public TextField getPersonal() {
        return personal;
    }

    public void setPersonal(String data) {
        this.personal = new TextField(data);
    }

    public TextField getObjective() {
        return objective;
    }

    public void setObjective(String data) {
        this.objective = new TextField(data);
    }

    public TextList getAchievement() {
        return achievement;
    }

    public void setAchievement(String... data) {
        this.achievement = new TextList(data);
    }

    public TextList getQualifications() {
        return qualifications;
    }

    public void setQualifications(String... data) {
        this.qualifications = new TextList(data);
    }

    public TextList[] getExperience() {
        return experience;
    }

    public void setExperience(String[]... data) {
        TextList[] lists = new TextList[data.length];
        for (int i = 0; i < data.length; i++) {
            lists[i] = new TextList(data[i]);
        }
        this.experience = lists;
    }

    public TextList[] getEducation() {
        return education;
    }

    public void setEducation(String[]... data) {
        TextList[] lists = new TextList[data.length];
        for (int i = 0; i < data.length; i++) {
            lists[i] = new TextList(data[i]);
        }
        this.education = lists;
    }
}
