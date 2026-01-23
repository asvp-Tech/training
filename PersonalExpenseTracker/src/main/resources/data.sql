-- =====================================================
-- Default Categories + Admin User (PostgreSQL)
-- =====================================================

-- ===============================
-- 1. Insert ADMIN user
-- ===============================
-- Email    : admin@expense.com
-- Password : admin@123 (BCrypt)

INSERT INTO users (email, password, full_name, role)
VALUES (
    'admin@expense.com',
    '$2a$10$y0K.J720sZYqJ3ia11.AQ.edaLd5EiYjGZTD/gIr78E9lJ.IrZ9qy',
    'System Admin',
    'ADMIN'
)
ON CONFLICT (email) DO NOTHING;

-- ===============================
-- 2. Insert Default Categories
-- ===============================

INSERT INTO categories (name, is_default, user_id)
VALUES
    ('FOOD', true, NULL),
    ('TRANSPORT', true, NULL),
    ('ENTERTAINMENT', true, NULL),
    ('BILLS', true, NULL),
    ('OTHERS', true, NULL)
ON CONFLICT (name, user_id) DO NOTHING;
