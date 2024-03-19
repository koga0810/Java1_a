document.addEventListener('DOMContentLoaded', function() {
    const today = new Date();
    let currentMonth = today.getMonth();
    let currentYear = today.getFullYear();

    // 月名を日本語に変更
    const monthNames = ["1月", "2月", "3月", "4月", "5月", "6月",
                        "7月", "8月", "9月", "10月", "11月", "12月"];

    const calendarContainer = document.getElementById("calendar");
    const monthAndYear = document.getElementById("monthAndYear");

    function showCalendar(month, year) {
        const firstDay = new Date(year, month).getDay();
        const daysInMonth = 32 - new Date(year, month, 32).getDate();

        let tbl = "<table class='calendar-table'><thead><tr>";

        // 曜日名を日本語に変更
        for (let i = 0; i <= 6; i++) {
            tbl += "<th>" + ["日","月","火","水","木","金","土"][i] + "</th>";
        }
        tbl += "</tr></thead><tbody>";

        // カレンダーの日付を埋める
        let date = 1;
        for (let i = 0; i < 6; i++) {
            tbl += "<tr>";
            for (let j = 0; j < 7; j++) {
                if (i === 0 && j < firstDay) {
                    tbl += "<td></td>";
                } else if (date > daysInMonth) {
                    break;
                } else {
                    let cellClass = date === today.getDate() && year === today.getFullYear() && month === today.getMonth() ? " class='today'" : "";
                    tbl += "<td" + cellClass + ">" + date + "</td>";
                    date++;
                }
            }
            tbl += "</tr>";
            if (date > daysInMonth) {
                break;
            }
        }

        tbl += "</tbody></table>";
        calendarContainer.innerHTML = tbl;

        // 月と年をヘッダーに追加
        monthAndYear.textContent = year + "年 " + monthNames[month];
    }

    showCalendar(currentMonth, currentYear);
});
