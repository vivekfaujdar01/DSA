class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Convert event start and end times to minutes since 00:00
        int start1 = timeToMinutes(event1[0]);
        int end1 = timeToMinutes(event1[1]);
        int start2 = timeToMinutes(event2[0]);
        int end2 = timeToMinutes(event2[1]);

        // Check if there is an overlap between event1 and event2
        return (start1 <= end2 && start2 <= end1);
    }

    // Helper method to convert "HH:MM" string to minutes since 00:00
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}