#!/usr/bin/env python3
"""
Test script to validate EDEX Dev Container functionality.
This script tests that EDEX services are running and accessible.
"""

import socket
import sys

def test_port_open(host, port, service_name):
    """Test if a port is open and accepting connections."""
    try:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.settimeout(2)
        result = sock.connect_ex((host, port))
        sock.close()
        
        if result == 0:
            print(f"✓ {service_name} (port {port}): OPEN")
            return True
        else:
            print(f"✗ {service_name} (port {port}): CLOSED")
            return False
    except Exception as e:
        print(f"✗ {service_name} (port {port}): ERROR - {e}")
        return False

def main():
    print("=" * 60)
    print("AWIPS2 EDEX Dev Container Connectivity Test")
    print("=" * 60)
    print()
    
    tests_passed = 0
    tests_total = 0
    
    services = [
        ("localhost", 9581, "EDEX HTTP API"),
        ("localhost", 9582, "PyPIES HTTP"),
        ("localhost", 5432, "PostgreSQL"),
        ("localhost", 5672, "Qpid AMQP"),
    ]
    
    for host, port, service in services:
        tests_total += 1
        if test_port_open(host, port, service):
            tests_passed += 1
    
    print()
    print("=" * 60)
    print(f"Results: {tests_passed}/{tests_total} services accessible")
    print("=" * 60)
    
    if tests_passed == tests_total:
        print("\n✓ All EDEX services are running correctly!")
        sys.exit(0)
    else:
        print(f"\n✗ {tests_total - tests_passed} service(s) not accessible")
        sys.exit(1)

if __name__ == "__main__":
    main()
