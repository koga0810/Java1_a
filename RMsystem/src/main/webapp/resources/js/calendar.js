// グローバル変数の定義
let currentMonth = new Date().getMonth();
let currentYear = new Date().getFullYear();

function showCalendar(month, year) {
    const today = new Date();
    const monthNames = ["1月", "2月", "3月", "4月", "5月", "6月",
                        "7月", "8月", "9月", "10月", "11月", "12月"];
    const dayNames = ["日", "月", "火", "水", "木", "金", "土"];
    const firstDay = new Date(year, month).getDay();
    const daysInMonth = 32 - new Date(year, month, 32).getDate();

    let tbl = "<table class='calendar-table'><thead><tr>";
    
    // 曜日のヘッダーを追加
    for (let i = 0; i <= 6; i++) {
        tbl += "<th>" + dayNames[i] + "</th>";
    }
    tbl += "</tr></thead><tbody>";
    
    // 日付を埋める
    let date = 1;
    for (let i = 0; i < 6; i++) {
        tbl += "<tr>";
        for (let j = 0; j < 7; j++) {
            if (i === 0 && j < firstDay) {
                tbl += "<td></td>"; // 空白のセル
            } else if (date > daysInMonth) {
                break; // 月の最終日を超えたらループを抜ける
            } else {
                let cellClass = date === today.getDate() && year === today.getFullYear() && month === today.getMonth() ? " class='today'" : "";
                tbl += "<td" + cellClass + ">" + date + "</td>";
                date++;
            }
        }
        tbl += "</tr>";
        if (date > daysInMonth) {
            break; // 月の最終日を超えたら全体のループを抜ける
        }
    }
    
    tbl += "</tbody></table>";
    const calendarContainer = document.getElementById("calendar");
    calendarContainer.innerHTML = tbl;
    document.getElementById("monthAndYear").textContent = year + "年 " + monthNames[month];
}

function changeMonth(step) {
    currentMonth += step;
    if (currentMonth < 0) {
        currentMonth = 11;
        currentYear -= 1;
    } else if (currentMonth > 11) {
        currentMonth = 0;
        currentYear += 1;
    }
    showCalendar(currentMonth, currentYear);
}

// 初期カレンダーの表示と関数のグローバル公開
document.addEventListener('DOMContentLoaded', function() {
    showCalendar(currentMonth, currentYear);
    window.changeMonth = changeMonth;
});
