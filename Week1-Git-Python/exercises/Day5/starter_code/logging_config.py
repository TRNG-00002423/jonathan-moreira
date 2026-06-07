"""
Configure logging for the QA Test Framework.

Requirements:
1. Console handler: Show INFO and above, concise format
2. File handler: Capture DEBUG and above, detailed format with timestamps
3. Use a RotatingFileHandler (max 1MB, keep 3 backups)
"""

import logging
from logging.handlers import RotatingFileHandler


def setup_logging(log_file="test_framework.log", console_level=logging.INFO):
    """Configure and return the root logger for the framework.

    Args:
        log_file: Path to the log file
        console_level: Minimum level for console output

    Returns:
        logging.Logger configured with both handlers
    """
    # Create logger named "qa_framework"
    logger = logging.getLogger("qa_framework")
    
    # Add StreamHandler for console (INFO+)
    log_console = logging.StreamHandler()
    log_console.setLevel(console_level)

    # Add RotatingFileHandler for file (DEBUG+)
    file_handler = RotatingFileHandler(log_file, maxBytes = 1024 * 1024, backupCount = 3)
    file_handler.setLevel(logging.DEBUG)

    # Set appropriate formatters on each handler
    file_handler.setFormatter(logging.Formatter(
        fmt="%(asctime)s | %(levelname)-8s | %(name)s | %(funcName)s |%(message)s",
        datefmt="%H:%M:%S"
    ))

    log_console.setFormatter(logging.Formatter(
        fmt="%(asctime)s | %(message)s",
        datefmt="%H:%M:%S"
    ))

    logger.addHandler(log_console)
    logger.addHandler(file_handler)
    # TODO: Return the configured logger
    
    return logger
    