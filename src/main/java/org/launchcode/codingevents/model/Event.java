package org.launchcode.codingevents.model;



import java.util.Objects;

    public class Event {
        private String name;
        private String eventDescription;
        private int id;
        private static int nextId = 1;

        public Event(String name, String eventDescription) {
            this.name = name;
            this.eventDescription = eventDescription;
            this.id = nextId;
            nextId ++;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Event)) return false;
            Event event = (Event) o;
            return getId() == event.getId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId());
        }
    }



