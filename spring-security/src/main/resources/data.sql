insert into issues (summary, description) values ('バグA', 'バグがあります');
insert into issues (summary, description) values ('機能要望B', 'Bに追加機能がほしいです');
insert into issues (summary, description) values ('画面Cが遅い', '早くしてほしいです');

-- ハッシュ化前 password1234
insert into users (username, password, authority) values ('tom', 'a89de9b5e39efe9a862d84bcc80e176df8d371f85663717abc004c1baf9835b8aa711bf59fd81e55', 'ADMIN');
insert into users (username, password, authority) values ('bob', 'add11716d187a4fbb528f4ea11e4a891e4240692d2ce8c80fed4aaf5868ae6f5d343660be012d9aa', 'USER');
