# Loan-book
Mục tiêu:
Luyện tập sử dụng Spring AOP và Spring handler expection.

Mô tả:
Tạo ứng dụng hỗ trợ mượn sách.

Ứng dụng có thể liệt kê danh sách các đầu sách trên thư viện, mỗi đầu sách có số lượng còn lại (chưa được mượn).

Ai cũng có thể mượn sách, khi mượn sách thì người dùng sẽ đi tới màn hình chi tiết cuốn sách và sử dụng chức năng mượn, chức năng này giảm số lượng sách còn lại trên hệ thống xuống 1, và sẽ cấp cho người dùng một mã số mượn sách ngẫu nhiên gồm 5 chữ số.

Khi đọc xong và đi trả sách thì người dùng có thể vào màn hình trả sách, điền mã vào để báo là đã trả sách, số lượng sách của đầu sách tương ứng sẽ tăng lên 1.

Nếu số lượng sách xuống tới 0 thì sẽ không mượn được và gặp màn hình lỗi.

Nếu mã số sai thì sẽ không mượn được và gặp lỗi.

Thực hiện ghi log tất cả các hành động khiến trạng thái sách của thư viện bị thay đổi.

Thực hiện ghi log số lượng người đã ghé thăm thư viện sách (tất cả các thao tác). Gợi ý: ở đây cần sử dụng một join point khác với afterthrowing.
